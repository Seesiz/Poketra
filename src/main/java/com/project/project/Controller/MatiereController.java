package com.project.project.Controller;

import com.project.project.Model.Look;
import com.project.project.Model.Matiere;
import com.project.project.Model.Matiere_Look;
import com.project.project.Model.repository.LookRepo;
import com.project.project.Model.repository.MatiereLookRepo;
import com.project.project.Model.repository.MatiereRepo;
import com.project.project.Model.repository.UniteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/matiere")
public class MatiereController {
    @Autowired
    private MatiereRepo matRepo;

    @Autowired
    private UniteRepo unitRepo;

    @Autowired
    private LookRepo lookRepo;

    @Autowired
    private MatiereLookRepo matiereLookRepoRepo;


    @PostMapping
    public String addMatiere(@RequestParam("mat_nom") String matNom,
                             @RequestParam("mat_unite") int matUniteId,
                             @RequestParam("mat_prixunitaire") double matPrixUnitaire,
                             @RequestParam(name = "look", required = false) List<Integer> looks,
                             Model model) {
        Matiere matiere = new Matiere();
        matiere.setMat_nom(matNom);
        matiere.setMat_unite(unitRepo.getUniteByUniId(matUniteId));
        matiere.setMat_prixunitaire(matPrixUnitaire);
        matRepo.save(matiere);
        if (looks != null && !looks.isEmpty()) {
            for (Integer lookId : looks) {
                Look look = lookRepo.getLookByLookId(lookId);
                Matiere_Look matiereLook = new Matiere_Look();
                matiereLook.setMatdet_matiere(matiere);
                matiereLook.setMatdetLook(look);
                matiereLookRepoRepo.save(matiereLook);
            }
        }
        model.addAttribute("page", "matiere");
        model.addAttribute("title", "Matiere");
        return "redirect:/main/?title=Matiere&page=matiere";
    }
}
