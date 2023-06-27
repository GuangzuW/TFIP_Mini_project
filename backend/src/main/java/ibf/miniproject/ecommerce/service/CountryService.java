package ibf.miniproject.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf.miniproject.ecommerce.model.Country;
import ibf.miniproject.ecommerce.repository.CountryRepository;
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findById(Integer id) {
        return countryRepository.findById(id);
    }
    
    
}
