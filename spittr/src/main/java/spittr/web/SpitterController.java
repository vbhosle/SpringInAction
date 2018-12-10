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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
				RedirectAttributes model,
				Errors errors
	 ) throws IllegalStateException, IOException {
		if(errors.hasErrors()) {
			return "registerForm";
		}
		spitterRepository.save(spitter);
		if (profilePicture.getSize() > 0) {
			System.out.println("ProfilePicture.getSize " + profilePicture.getSize());
			profilePicture.transferTo(
					new File("/data/spittr/" + profilePicture.getOriginalFilename()));
		}
		
		model.addAttribute("username", spitter.getUsername());
		model.addFlashAttribute("spitter", spitter);
		return "redirect:/spitter/{username}";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable("username") String username, Model model){
		if(!model.containsAttribute("spitter")) {
			Spitter spitter = spitterRepository.findByUsername(username);
			model.addAttribute(spitter);
		}
		return "profile";
	}
}
