package demo.config;

import demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;


/**
 授权服务器配置
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;//认证管理器

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    RedisTokenStore redisTokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }


    /**
     * 配置客户端详情信息
       能够使用
     InMemoryClientDetailsService 内存
     或者
     JdbcClientDetailsService  JDBC来实现客户端详情服务
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用in-memory存储
                .withClient("1") // client_id
                .secret("2") // client_secret
                .authorizedGrantTypes("password","authorization_code","refresh_token") // 该client允许的授权类型
                .scopes("app") // 允许的授权范围
                .autoApprove(true);

       // clients.withClientDetails(new InMemoryClientDetailsService());

        /*

            token存储方式共有三种分别是：
            （1）InMemoryTokenStore：存放内存中，不会持久化
            （2）JdbcTokenStore：存放数据库中
            （3）Jwt: json web token
         */
    }
    //@Bean
    //public ClientDetailsService clientDetails() {
    //    return new JdbcClientDetailsService(dataSource);
    //}


    /**
     * 配置令牌 管理
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(redisTokenStore())
                 .userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager);
        endpoints.tokenServices(defaultTokenServices());

        //       .accessTokenConverter() 配置token转换器
    }

    /**
     * <p>注意，自定义TokenServices的时候，需要设置@Primary，否则报错，</p>
     * @return
     */
    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices(){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(redisTokenStore());
        tokenServices.setSupportRefreshToken(true);
        //tokenServices.setClientDetailsService(clientDetails());
        tokenServices.setAccessTokenValiditySeconds(60*60*12); // token有效期自定义设置，默认12小时
        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);//默认30天，这里修改
        return tokenServices;
    }

    /**
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 开启/oauth/token_key验证端口无权限访问
        security.tokenKeyAccess("permitAll()");
        // 开启/oauth/check_token验证端口认证权限访问
        security .checkTokenAccess("isAuthenticated()");
        security.allowFormAuthenticationForClients();
    }
}
