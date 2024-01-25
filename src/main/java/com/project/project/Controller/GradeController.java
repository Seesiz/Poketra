package com.project.project.Controller;

import com.project.project.Model.Grade;
import com.project.project.Model.repository.GradeRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    GradeRepo gradeRepo;

    @GetMapping
    public String toGrade(Model model, HttpServletRequest request){
        model.addAttribute("page", "grade");
        model.addAttribute("title", "Grade");
        return "main-component";
    }
    @PostMapping
    public String insert(@RequestParam("grade") String grade, @RequestParam("taux") double taux, @RequestParam("debut") double debut, @RequestParam("fin") double fin){
        Grade g = new Grade();
        g.setGrade(grade);
        g.setDebut(debut);
        g.setFin(fin);
        g.setTaux(taux);
        gradeRepo.save(g);
        return "redirect:/grade";
    }
}
