// codes taken from chatgpt and edited by Sukhdeep ,Manjot and Simarjit
package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	private final PostRepository postRepository;

	public PostController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@GetMapping("/posts")
	public String viewPosts(@RequestParam Long threadId, Model model) {
		model.addAttribute("posts", postRepository.findAll());
		return "posts";
	}

	@PostMapping("/posts")
	public String createPost(Post post) {
		postRepository.save(post);
		return "redirect:/threads";
	}
}

