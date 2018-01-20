package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.CookingType;
import es.salesianos.service.Service;

@Controller
public class CookingTypeController {

	private static Logger log = LogManager.getLogger(CookingTypeController.class);

	@Autowired
	private Service service;

	@GetMapping("/CookingType")
	public ModelAndView index() {
		log.debug("entrando a insertar nuevo tipo de cocina");
		return new ModelAndView("cookingType", "command", new CookingType());
	}

	@PostMapping("/cookingTypeInsert")
	public ModelAndView create(@ModelAttribute("cookingType") CookingType cookingType) {
		log.debug("inserting cookingType");
		service.insert(cookingType);
		return new ModelAndView("cookingType", "command", new CookingType());
}
}
