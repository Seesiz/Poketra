package com.project.project.Controller;

import com.project.project.Model.Matiere;
import com.project.project.Model.PrixMatiere;
import com.project.project.Model.Sac;
import com.project.project.Model.SacPrix;
import com.project.project.Model.repository.MatiereRepo;
import com.project.project.Model.repository.PrixMatiereRepo;
import com.project.project.Model.repository.SacPrixRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/prixMatiere")
public class PrixMatiereController {
    @Autowired
    private PrixMatiereRepo pmr;

    @Autowired
    private MatiereRepo mr;

    @Autowired
    private SacPrixRepository spr;

    @GetMapping
    public String showPrix(HttpServletRequest request, Model model){
        List<PrixMatiere> all = pmr.getAllLastPrixMatiere();
        model.addAttribute("page", "prixMatiere");
        model.addAttribute("title", "Prix Matiere");
        request.setAttribute("prixMatiere", all);
        request.setAttribute("matieres", mr.findAll());
        return "main-component";
    }

    @PostMapping
    public String addPrix(
            @RequestParam("matiere") int matiere,
            @RequestParam("prix") double prix
    ){
        Date date = new Date();
        PrixMatiere p = new PrixMatiere();
        p.setPrixValue(prix);
        Matiere m = new Matiere();
        m.setMat_id(matiere);
        p.setPrixMatiere(m);
        p.setPrixDate(date);
        pmr.save(p);
        return "redirect:/prixMatiere";
    }

    @GetMapping("/{min}/{max}")
    @ResponseBody
    public List<SacPrix> getFiltre(@PathVariable("min") double min, @PathVariable("max") double max){
        System.out.println("Io e");
        return spr.findSacPrixBySacPrixBetween(min, max);
    }
}
