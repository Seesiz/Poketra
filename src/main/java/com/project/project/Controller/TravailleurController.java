package com.project.project.Controller;

import com.project.project.Model.Poste;
import com.project.project.Model.Salaire;
import com.project.project.Model.Travailleur;
import com.project.project.Model.repository.PosteRepo;
import com.project.project.Model.repository.SalaireRepo;
import com.project.project.Model.repository.TravailleurRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/travailleur")
public class TravailleurController {
    @Autowired
    private PosteRepo posteRepo;
    @Autowired
    private TravailleurRepo travailleurRepo;
    @Autowired
    private SalaireRepo salaireRepo;
    @GetMapping
    public String toTravailleur(Model model, HttpServletRequest request){
        request.setAttribute("postes", posteRepo.findAll());
        request.setAttribute("employers", salaireRepo.findAll());
        model.addAttribute("page", "travailleur");
        model.addAttribute("title", "Employer");
        return "main-component";
    }

    @PostMapping
    public String ajout(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("date") String dates, @RequestParam("poste") int poste){
        Travailleur t = new Travailleur();
        Poste p = new Poste();
        p.setIdPoste(poste);
        t.setNom(nom);
        t.setPoste(p);
        t.setPrenom(prenom);
        t.setDateEmbauche(dates);
        t.setEtat(1);
        t.setAugmentation(0);
        travailleurRepo.save(t);
        return "redirect:/travailleur";
    }

    @GetMapping("/{texte}")
    @ResponseBody
    public List<Salaire> Search(@PathVariable("texte") String texte){
        return salaireRepo.findAllByNomLikeOrPrenomLike(texte, texte);
    }
}
