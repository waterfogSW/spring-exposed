package org.waterfogsw.springexposed.adapter.inbound.ui

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.waterfogsw.springexposed.application.port.inbound.CreatePost
import org.waterfogsw.springexposed.application.port.inbound.GetPost
import org.waterfogsw.springexposed.domain.Post

@Controller
class PostUIController(
    private val getPost: GetPost,
    private val createPost: CreatePost,
) {

    @GetMapping("/")
    fun index(): String {
        return "redirect:/posts"
    }

    @GetMapping("/posts")
    fun index(model: Model): String {
        val posts: List<Post> = getPost.getList()
        model.addAttribute("posts", posts)
        return "posts"
    }

    @PostMapping("/posts")
    fun create(@ModelAttribute command: CreatePost.Command): String {
        createPost.create(command)
        return "redirect:/posts"
    }

}
