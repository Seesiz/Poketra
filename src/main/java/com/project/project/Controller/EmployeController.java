package com.project.project.Controller;

import com.project.project.Model.Employe;
import com.project.project.Model.Sac;
import com.project.project.Model.repository.SacRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employe")
public class EmployeController {
    @Autowired
    private SacRepo sacRepo;
    @GetMapping
    public String toEmploye(Model model, HttpServletRequest request){
        request.setAttribute("sacs", sacRepo.findAll());
        model.addAttribute("page", "employe");
        model.addAttribute("title", "Employe");
        return "main-component";
    }

    @PostMapping
    public String post(@ModelAttribute Employe e, @RequestParam("idsac") int idSac){
        Sac s = new Sac();
        s.setSacId(idSac);
        e.setSac_Employe(s);
        return "redirect:/employe";
    }
}
