package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/image")
public class ImageController {
	@Autowired
	private ImageRepository imageRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody Image add(@RequestParam String name) {
		Image image = new Image();
		image.setName(name);
		imageRepository.save(image);
		
		return image;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Image> getAll() {
		return imageRepository.findAll();
	}
}
