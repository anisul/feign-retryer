package com.grasshopper.feignretryer.service

import com.grasshopper.feignretryer.model.Post

interface JsonPlaceHolderServiceInterface {
    fun getPosts() : List<Post>
}