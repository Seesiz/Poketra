package com.project.project.Controller;

import com.project.project.Model.Benefice;
import com.project.project.Model.PrixVente;
import com.project.project.Model.Sac;
import com.project.project.Model.SacPrix;
import com.project.project.Model.repository.BeneficeRepo;
import com.project.project.Model.repository.PrixVenteRepo;
import com.project.project.Model.repository.SacRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/benefice")
public class BeneficeController {
    @Autowired
    private SacRepo sacRepo;
    @Autowired
    private PrixVenteRepo prixVenteRepo;
    @Autowired
    private BeneficeRepo beneficeRepo;
    @GetMapping
    public String toBenefice(Model model, HttpServletRequest request){
        request.setAttribute("sacs", sacRepo.findAll());
        model.addAttribute("page", "benefice");
        model.addAttribute("title", "Prix");
        return "main-component";
    }

    @PostMapping
    public String insert(@RequestParam("sac") int idSac, @RequestParam("prix") double prix){
        PrixVente pv = new PrixVente();
        pv.setPrix(prix);
        Sac s = new Sac();
        s.setSacId(idSac);
        pv.setSacPrix(s);
        pv.setDatePrix(new Date());
        prixVenteRepo.save(pv);
        return "redirect:/benefice";
    }

    @GetMapping("/{min}/{max}")
    @ResponseBody
    public List<Benefice> getFiltre(@PathVariable("min") double min, @PathVariable("max") double max){
        return beneficeRepo.findAllByBeneficeBetween(min, max);
    }
}
