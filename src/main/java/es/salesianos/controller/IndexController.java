package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Recipe;

@Controller
public class IndexController {

	private static Logger log = LogManager.getLogger(IndexController.class);

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", "command", new Recipe());
	}

	@PostMapping("recipeInsert")
	public ModelAndView recipeInsert(Recipe recipe) {
		log.debug("recipeInsert");
		return new ModelAndView("index", "command", recipe);
	}

	@PostMapping("ingredientInsert")
	public ModelAndView ingredientInsert(Recipe recipe) {
		log.debug("ingredientInsert");
		return new ModelAndView("index", "command", recipe);
	}

	@PostMapping("cookingToolInsert")
	public ModelAndView cookingToolInsert(Recipe recipe) {
		log.debug("cookingToolInsert");
		return new ModelAndView("index", "command", recipe);
	}

}
