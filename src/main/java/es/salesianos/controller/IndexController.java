package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.CookingTool;
import es.salesianos.model.Ingredient;
import es.salesianos.model.Recipe;

@Controller
public class IndexController {

	private static Logger log = LogManager.getLogger(IndexController.class);

	private Recipe recipe;

	@GetMapping("/")
	public ModelAndView index() {
		recipe = new Recipe();
		ModelAndView modelAndView = new ModelAndView("index", "command", recipe);
		modelAndView.addObject("recipe", this.recipe);
		return modelAndView;
	}

	@PostMapping("recipeInsert")
	public ModelAndView recipeInsert(Recipe recipe) {
		log.debug("recipeInsert:" + this.recipe.toString());
		ModelAndView modelAndView = new ModelAndView("index", "command", recipe);
		addPageData(recipe);
		modelAndView.addObject("recipe", this.recipe);
		return modelAndView;
	}

	private void addPageData(Recipe recipeForm) {

		if (!StringUtils.isEmpty(recipeForm.getName())) {
			this.recipe.setName(recipeForm.getName());
		}

		if (!StringUtils.isEmpty(recipeForm.getCookingToolName())) {
			CookingTool cookingTool = new CookingTool();
			cookingTool.setName(recipeForm.getCookingToolName());
			recipeForm.setCookingToolName("");
			this.recipe.getTools().add(cookingTool);
		}
		if (!StringUtils.isEmpty(recipeForm.getIngredientName())) {
			Ingredient ingredient = new Ingredient();
			ingredient.setName(recipeForm.getIngredientName());
			recipeForm.setIngredientName("");
			this.recipe.getIngredients().add(ingredient);
		}
	}

	@PostMapping("ingredientInsert")
	public ModelAndView ingredientInsert(Recipe recipe) {
		log.debug("ingredientInsert:" + this.recipe.toString());
		addPageData(recipe);
		ModelAndView modelAndView = new ModelAndView("index", "command", recipe);
		modelAndView.addObject("recipe", this.recipe);
		return modelAndView;
	}

	@PostMapping("cookingToolInsert")
	public ModelAndView cookingToolInsert(Recipe recipe) {
		log.debug("cookingToolInsert:" + this.recipe.toString());
		addPageData(recipe);
		ModelAndView modelAndView = new ModelAndView("index", "command", recipe);
		modelAndView.addObject("recipe", this.recipe);
		return modelAndView;
	}

}