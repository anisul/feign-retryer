package com.grasshopper.feignretryer.client

import feign.Response
import feign.RetryableException
import feign.Retryer
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.Exception
import java.util.concurrent.TimeUnit


@Configuration
class JsonPlaceholderClientConfig {

    @Bean
    fun retryer(): Retryer {
        return Retryer.Default(100L, TimeUnit.SECONDS.toMillis(1L), 2)
    }

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return CustomErrorDecoder()
    }

    class CustomErrorDecoder: ErrorDecoder {
        override fun decode(methodKey: String, response: Response): Exception {
            val defaultErrorDecoder = ErrorDecoder.Default();
            val exception = defaultErrorDecoder.decode(methodKey, response)

            if (exception is RetryableException) {
                return exception
            }

            if (response.status() == 504) {
                return RetryableException(
                    response.status(),
                    response.reason(),
                    response.request().httpMethod(),
                    null,
                    response.request()
                )
            }

            return exception;
        }
    }
}