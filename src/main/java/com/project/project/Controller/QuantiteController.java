package com.project.project.Controller;

import com.project.project.Model.Matiere_Look;
import com.project.project.Model.QuantiteM;
import com.project.project.Model.Taille;
import com.project.project.Model.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/quantite")
public class QuantiteController {
    @Autowired
    private QuantiteRepo quantiteRepo;
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
    private MatiereLookRepo matiereLookRepo;
    @Autowired
    private MatiereRepo matiereRepo;

    @GetMapping
    public String quantite(Model model, HttpServletRequest request){
        request.setAttribute("taille", tailleRepo.findAll());
        request.setAttribute("matiereLook", matiereLookRepo.findAll());
        model.addAttribute("page", "quantite");
        model.addAttribute("title", "Quantite");
        return "main-component";
    }

    @PostMapping
    public String insert(@RequestParam("taille") int taille, @RequestParam("matlook") int matlook, @RequestParam("quantite") double quantite){
        QuantiteM qm = new QuantiteM();
        Taille t = new Taille();
        t.setTailleId(taille);
        qm.setQuanTaille(t);
        Matiere_Look mt = new Matiere_Look();
        mt.setMatdet_id(matlook);
        qm.setQuanMatiereLook(mt);
        qm.setQuanValue(quantite);
        quantiteRepo.save(qm);
        return "redirect:/quantite";
    }

    @PostMapping("/quant")
    @ResponseBody
    public HashMap<String, Object> getQuanite(@RequestParam("idMatLook") int id, @RequestParam("idTaille") int idTaille){
        Matiere_Look mt = new Matiere_Look();
        mt.setMatdet_id(id);
        Taille t = new Taille();
        t.setTailleId(idTaille);
        QuantiteM qm = quantiteRepo.getByQuanMatiereLookAndQuanTaille(mt, t);
        HashMap<String, Object> quantite = new HashMap<>();
        quantite.put("quantite", qm);
        return quantite;
    }
}
