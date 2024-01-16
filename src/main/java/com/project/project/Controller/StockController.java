package com.project.project.Controller;

import com.project.project.Model.Matiere;
import com.project.project.Model.Reste;
import com.project.project.Model.StockMatiere;
import com.project.project.Model.repository.MatiereRepo;
import com.project.project.Model.repository.ResteRepo;
import com.project.project.Model.repository.StockMatiereRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/stockMatiere")
public class StockController {

    @Autowired
    private StockMatiereRepo stmatRepo;

    @Autowired
    private MatiereRepo matiereRepo;

    @Autowired
    private ResteRepo resteRepo;

    @GetMapping
    public String toStock(HttpServletRequest request, Model model){
        List<Matiere> all = matiereRepo.findAll();
        model.addAttribute("page", "stock");
        model.addAttribute("title", "Stock");
        request.setAttribute("matieres", all);
        request.setAttribute("restes", resteRepo.findAll());
        return "main-component";
    }

    @GetMapping("/{value}")
    @ResponseBody
    public List<Reste> search(@PathVariable("value") String value){
        List<Reste> allReste = resteRepo.findAllByMatNomLike(value);
        return allReste;
    }
    @PostMapping
    public String insert(@RequestParam("matiere") int idMatiere, @RequestParam("quantite") double quantite, @RequestParam("date") String dateString){
        StockMatiere mat = new StockMatiere();
        Matiere ma = new Matiere();
        ma.setMat_id(idMatiere);
        mat.setMatStockmat(ma);
        mat.setEtatStockmat(1);
        mat.setQuanStockmatEntree(quantite);
        mat.setQuanStockmatSortie(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(dateString);
            mat.setDateStockmat(date);
            mat = stmatRepo.save(mat);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/stockMatiere";
    }
}
