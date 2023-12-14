package com.project.project.Controller;

import com.project.project.Model.Type;
import com.project.project.Model.repository.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/type")
public class TypeContoller {
    @Autowired
    private TypeRepo typeRepo;

    @PostMapping
    public String insertType(@ModelAttribute Type type, Model model){
        HashMap<String, Object> response = new HashMap<>();
        try {
            Type t = typeRepo.save(type);
            response.put("statut", true);
            response.put("data", t);
        }catch (RuntimeException e){
            response.put("statut", false);
            response.put("message", e.getMessage());
        }
        model.addAttribute("page", "look");
        model.addAttribute("title", "Look");
        model.addAttribute("response", response);
        return "main-component";
    }
}
