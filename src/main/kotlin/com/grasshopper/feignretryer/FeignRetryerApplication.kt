package com.grasshopper.feignretryer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class FeignRetryerApplication

fun main(args: Array<String>) {
	runApplication<FeignRetryerApplication>(*args)
}
