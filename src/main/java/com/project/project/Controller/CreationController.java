package com.project.project.Controller;

import com.project.project.Model.*;
import com.project.project.Model.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("/creation")
public class CreationController {
    @Autowired
    private LookRepo lookRepo;
    @Autowired
    private TypeRepo typeRepo;
    @Autowired
    private TailleRepo tailleRepo;
    @Autowired
    private SacRepo sacRepo;
    @Autowired
    private SacMatiereRepo sacMatiere;
    @Autowired
    private MatiereRepo matiereRepo;

    @GetMapping
    public String toCreate(Model model, HttpServletRequest request){
        request.setAttribute("look",lookRepo.findAll());
        request.setAttribute("type",typeRepo.findAll());
        request.setAttribute("taille",tailleRepo.findAll());
        request.setAttribute("matiere", matiereRepo.findAll());
        model.addAttribute("page", "creation");
        model.addAttribute("title", "Creation");
        return "main-component";
    }

    @PostMapping
    public String handleCreationPost(@RequestParam("nom") String mat_nom,
                                     @RequestParam("look") int mat_look,
                                     @RequestParam("type") int mat_type,
                                     @RequestParam("taille") int mat_taille,
                                     @RequestParam("matiere") List<Integer> matiereIds,
                                     HttpServletRequest request,
                                     Model model) {
        try{
            Sac sac = new Sac();
            sac.setSacNom(mat_nom);
            Look l = new Look();
            l.setLookId(mat_look);
            Type t = new Type();
            t.setTypeId(mat_type);
            Taille ta = new Taille();
            ta.setTailleId(mat_taille);
            sac.setSacLook(l);
            sac.setSacTaille(ta);
            sac.setSacType(t);
            Sac s = sacRepo.save(sac);
            for(int i : matiereIds){
                Matiere m = new Matiere();
                m.setMat_id(i);
                SacMatiere sm = new SacMatiere();
                sm.setSacMatiereQuantite(Double.parseDouble(request.getParameter("q_"+i)));
                sm.setSacSac(s);
                sm.setSacMatiere(m);
                sacMatiere.save(sm);
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return "redirect:/creation";
    }

    @GetMapping("/{idMatiere}")
    @ResponseBody
    public List<SacMatiere> getSacByMatiere(@PathVariable("idMatiere") int matiere){
        Matiere m = new Matiere();
        m.setMat_id(matiere);
        return sacMatiere.getAllBySacMatiere(m);
    }
}
