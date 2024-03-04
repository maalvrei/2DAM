package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.Insulto;

@Service
public class InsultoService {

    @Autowired
    private RestTemplate restTemplate;
    
    private String apiUrl = "https://evilinsult.com/generate_insult.php?lang=en&type=json";

    public Insulto getInsulto() {
        return restTemplate.getForObject(apiUrl, Insulto.class);
    }
}