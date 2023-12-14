package com.project.project.Controller;

import com.project.project.Model.Look;
import com.project.project.Model.Unite;
import com.project.project.Model.repository.LookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/look")
public class LookController {
    @Autowired
    private LookRepo lookRepo;

    @PostMapping
    @ResponseBody
    public HashMap<String, Object> insertLook(@ModelAttribute Look look){
        HashMap<String, Object> response = new HashMap<>();
        try{
            Look u = lookRepo.save(look);
            response.put("statut", true);
            response.put("data", u);
        } catch (RuntimeException e){
            response.put("statut", false);
        }
        return response;
    }

    @GetMapping
    @ResponseBody
    public List<Look> getLook(){
        return lookRepo.findAll();
    }
}
