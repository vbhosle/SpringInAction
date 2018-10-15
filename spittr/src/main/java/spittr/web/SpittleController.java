package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	//book lists different ways to write the spittles method
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model) {
		//add spittles to the model
		model.addAttribute("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles"; //view name 
	}
}
