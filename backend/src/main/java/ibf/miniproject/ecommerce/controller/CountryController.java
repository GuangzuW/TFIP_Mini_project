package ibf.miniproject.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf.miniproject.ecommerce.service.CountryService;

@Controller
@RequestMapping(path="/api")    
public class CountryController {

    @Autowired
    private CountryService countryService;

    
}
