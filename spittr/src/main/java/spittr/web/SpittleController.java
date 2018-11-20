package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private static final String MAX_LONG_AS_STRING = "" +Long.MAX_VALUE;
	
	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	//book lists different ways to write the spittles method
	//Note: logical view name is inferred from the request path. Because this
	//method handles GET requests for /spittles, the view name is spittles
	/* When a handler method returns an object or a collection like this, the value returned is put
	into the model, and the model key is inferred from its type (spittleList)
	*/
	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittles(
			@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
			@RequestParam(value="count", defaultValue="20") int count
			) {
		return spittleRepository.findSpittles(max, count);
	}
	
	@RequestMapping(value="/{spittleID}", method= {RequestMethod.GET})
	public String getSpittleById(
			@PathVariable("spittleID") long spittleID,
			Model model
	) {
		model.addAttribute("spittle", spittleRepository.findOne(spittleID));
		return "spittle";
	}
}
