package com.project.project.Controller;

import com.project.project.Model.Unite;
import com.project.project.Model.repository.UniteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/unite")
public class UniteController {
    @Autowired
    private UniteRepo uniteRepo;

    @PostMapping
    @ResponseBody
    public HashMap<String, Object> insertUnite(@ModelAttribute Unite unite){
        HashMap<String, Object> response = new HashMap<>();
        System.out.println(unite.getUni_nom());
        try{
            Unite u = uniteRepo.save(unite);
            response.put("statut", true);
            response.put("data", u);
        } catch (RuntimeException e){
            response.put("statut", false);
        }
        return response;
    }

    @GetMapping
    @ResponseBody
    public List<Unite> getUnite(){
        return uniteRepo.findAll();
    }
}
