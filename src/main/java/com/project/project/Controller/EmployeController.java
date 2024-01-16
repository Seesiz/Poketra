package com.project.project.Controller;

import com.project.project.Model.Employe;
import com.project.project.Model.Sac;
import com.project.project.Model.repository.EmployeRepo;
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
    @Autowired
    private EmployeRepo employeRepo;
    @GetMapping
    public String toEmploye(Model model, HttpServletRequest request){
        request.setAttribute("sacs", sacRepo.findAll());
        model.addAttribute("page", "employe");
        model.addAttribute("title", "Employe");
        return "main-component";
    }

    @PostMapping
    public String post(@RequestParam("designation_Employe") String des,  @RequestParam("quantite_Employe") int quan, @RequestParam("duree_Employe") double duree, @RequestParam("salaire_Employe") double salaire, @RequestParam("idsac") int idSac){
        System.out.println(idSac);
        Employe e = new Employe();
        e.setDesignation_Employe(des);
        e.setDuree_Employe(duree);
        e.setSalaire_Employe(salaire);
        e.setQuantite_Employe(quan);
        Sac s = new Sac();
        s.setSacId(idSac);
        e.setSac_Employe(s);
        employeRepo.save(e);
        return "redirect:/employe";
    }
}
