package com.project.project.Controller;

import com.project.project.Model.Sac;
import com.project.project.Model.StatistiqueGenre;
import com.project.project.Model.Vente;
import com.project.project.Model.repository.SacRepo;
import com.project.project.Model.repository.StatGenreRepo;
import com.project.project.Model.repository.VenteRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/statistique")
public class StatistiqueController {
    @Autowired
    private StatGenreRepo statGenreRepo;
    @Autowired
    private SacRepo sacRepo;
    @GetMapping
    public String toStat(Model model, HttpServletRequest request){
        List<StatistiqueGenre> statistique = statGenreRepo.findAll();
        request.setAttribute("statistique", statistique);
        model.addAttribute("page", "statistique");
        model.addAttribute("title", "Statistique");
        return "main-component";
    }

    @GetMapping("/{idSac}")
    @ResponseBody
    public StatistiqueGenre getStat(@PathVariable("idSac") int idSac){
        StatistiqueGenre statistiqueGenre  = statGenreRepo.findById(idSac).get();
        return statistiqueGenre;
    }

}
