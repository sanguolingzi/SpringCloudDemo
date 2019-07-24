package demo.config;

import feign.Request;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 集成feign.logger重写其方法适应info级别的日志舒服
 */
//@Component  //放置在core 避免多个feign引用重复
public class FeignBankRollLogger extends feign.Logger {
    private final Logger logger;

    public FeignBankRollLogger() {
        this(feign.Logger.class);
    }

    public FeignBankRollLogger(Class<?> clazz) {
        this(LoggerFactory.getLogger(clazz));
    }

    public FeignBankRollLogger(String name) {
        this(LoggerFactory.getLogger(name));
    }

    FeignBankRollLogger(Logger logger) {
        this.logger = logger;
    }


    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        if (logger.isInfoEnabled()) {
            super.logRequest(configKey, logLevel, request);
        }
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response, long elapsedTime)
            throws IOException {
        if (logger.isInfoEnabled()) {
            return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
        }
        return response;
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
        // Not using SLF4J's support for parameterized messages (even though it
        // would be more efficient) because it would
        // require the incoming message formats to be SLF4J-specific.
        if (logger.isInfoEnabled()) {
            logger.info(String.format(methodTag(configKey) + format, args));
        }
    }
}
