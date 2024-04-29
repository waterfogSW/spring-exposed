package org.waterfogsw.springexposed.adapter.inbound.ui

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.waterfogsw.springexposed.application.port.inbound.CreatePost
import org.waterfogsw.springexposed.application.port.inbound.GetPost
import org.waterfogsw.springexposed.application.port.inbound.UpdatePost
import org.waterfogsw.springexposed.domain.Post
import java.util.*

@Controller
class PostUIController(
    private val getPost: GetPost,
    private val createPost: CreatePost,
    private val updatePost: UpdatePost,
) {

    @GetMapping("/")
    fun index(): String {
        return "redirect:/posts"
    }

    @GetMapping("/posts")
    fun index(model: Model): String {
        val posts: List<Post> = getPost.getList()
        model.addAttribute("posts", posts)
        return "post/list"
    }

    @GetMapping("/posts/{id}")
    fun detail(
        @PathVariable id: UUID,
        model: Model,
    ): String {
        val post: Post = getPost.getById(id)
        model.addAttribute("post", post)
        return "post/detail"
    }

    @PostMapping("/posts")
    fun create(@ModelAttribute command: CreatePost.Command): String {
        createPost.create(command)
        return "redirect:/posts"
    }

    @PostMapping("/posts/{id}")
    fun update(
        @PathVariable id: UUID,
        @ModelAttribute command: UpdatePost.Command,
    ): String {
        updatePost.updateById(id, command)
        return "redirect:/posts/$id"
    }

}
