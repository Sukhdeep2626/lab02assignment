package com.example.demo.controller;

import com.example.demo.model.Thread;
import com.example.demo.repository.ThreadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThreadController {

	private final ThreadRepository threadRepository;

	public ThreadController(ThreadRepository threadRepository) {
		this.threadRepository = threadRepository;
	}

	@GetMapping("/threads")
	public String listThreads(Model model) {
		model.addAttribute("threads", threadRepository.findAll());
		return "threads";
	}

	@PostMapping("/threads")
	public String createThread(Thread thread) {
		threadRepository.save(thread);
		return "redirect:/threads";
	}
}

