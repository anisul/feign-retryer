package com.grasshopper.feignretryer.client

import com.grasshopper.feignretryer.model.Post
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "jsonPlaceholderClient", url = "https://run.mocky.io/v3/f2c67d9d-6ede-4acf-a20e-0985f79e421f", configuration = [JsonPlaceholderClientConfig::class])
interface JsonPlaceholderClient {

    @GetMapping
    fun getPosts(): List<Post>
}