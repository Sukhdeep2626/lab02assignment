# lab02assignment

Sukhdeep , manjot and Simarjeet have worked togther as a group project in this lab.

codes for controller are taken from Chatgpt and edited by Sukhdeep and manjot
01)

("/posts")
	public String viewPosts(@RequestParam Long threadId, Model model) {
		model.addAttribute("posts", postRepository.findAll());
		return "posts";
	}

 02)
 public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

 
@GetMapping("/register")
	public String showRegistrationForm() {
		return "register";
	}
	03)
 @PostMapping("/register")
	public String registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "redirect:/login";
	}

 @PostMapping("/threads")
	public String createThread(Thread thread) {
		threadRepository.save(thread);
		return "redirect:/threads";
	}
}


left of the codes are done by three of us on our own

 
 
