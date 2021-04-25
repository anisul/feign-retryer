package com.grasshopper.feignretryer.controller

import com.grasshopper.feignretryer.model.Post
import com.grasshopper.feignretryer.service.JsonPlaceholderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/v1/api"])
class MainController(val jsonPlaceholderService: JsonPlaceholderService) {

    @GetMapping("/posts")
    fun getMock(): List<Post> {
        return jsonPlaceholderService.getPosts()
    }
}