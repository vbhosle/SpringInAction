package spittr.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpitterRepository spitterRepository;
	
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
	
	@RequestMapping(value="register", method= RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("spitter",new Spitter());
		return "registerForm";
	}
	
	@RequestMapping(value="register", method= RequestMethod.POST)
	public String processRegistration(
				@RequestPart("profilePicture") MultipartFile profilePicture,
				@Valid Spitter spitter, 
				Errors errors
	 ) throws IllegalStateException, IOException {
		if(errors.hasErrors()) {
			return "registerForm";
		}
		spitterRepository.save(spitter);
		profilePicture.transferTo(
				new File("/data/spittr/" + profilePicture.getOriginalFilename()));
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable("username") String username, Model model){
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute(spitter);
		return "profile";
	}
}
