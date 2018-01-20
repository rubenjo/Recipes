package es.salesianos.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.CookingType;
import es.salesianos.repository.CookingTypeRepository;

@Service
public class CookingTypeService implements es.salesianos.service.Service {

	private static Logger log = LogManager.getLogger(CookingTypeService.class);

	@Autowired
	private CookingTypeRepository repository;

	@Override
	public void insert(CookingType cookingType) {
		repository.insert(cookingType);
	}

	public CookingTypeRepository getRepository() {
		return repository;
	}

	public void setRepository(CookingTypeRepository repository) {
		this.repository = repository;
	}

}
