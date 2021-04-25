package com.grasshopper.feignretryer.service

import com.grasshopper.feignretryer.client.JsonPlaceholderClient
import com.grasshopper.feignretryer.model.Post
import org.springframework.stereotype.Service

@Service
class JsonPlaceholderService(val client: JsonPlaceholderClient): JsonPlaceHolderServiceInterface{

    override fun getPosts(): List<Post> {
        return client.getPosts()
    }
}