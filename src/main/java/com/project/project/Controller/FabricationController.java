package com.project.project.Controller;

import com.project.project.Model.*;
import com.project.project.Model.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/fabrication")
public class FabricationController {

    @Autowired
    private SacRepo sacRepo;
    @Autowired
    private SacMatiereRepo sacMatiereRepo;
    @Autowired
    private ResteRepo resteRepo;
    @Autowired
    private StockMatiereRepo stockMatiereRepo;
    @Autowired
    private StockSacRepo stockSacRepo;
    @Autowired
    private ResteStockSacRepo resteStockSac;
    @GetMapping
    public String toFabrication(HttpServletRequest request, Model model){
        request.setAttribute("sacs",sacRepo.findAll());
        model.addAttribute("error", "");
        model.addAttribute("page", "fabrication");
        model.addAttribute("title", "Fabrication");
        return "main-component";
    }
    @PostMapping
    public String fabriquer(@RequestParam("sac") int idSac, @RequestParam("quantite") double quantite, @RequestParam("date") String dateString, HttpServletRequest request, Model model){
        model.addAttribute("page", "fabrication");
        model.addAttribute("title", "Fabrication");
        request.setAttribute("sacs",sacRepo.findAll());
        StockSac stockSac = new StockSac();
        Sac s = sacRepo.findById(idSac).get();
        stockSac.setQuanStockEntre(quantite);
        stockSac.setQuanStockSortie(0);
        stockSac.setSacStock(s);
        stockSac.setEtatStock(1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
            stockSac.setDateSac(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<SacMatiere> sacMatieres = sacMatiereRepo.getAllBySacSac(s);
        List<Reste> restes = resteRepo.findAll();
        List<StockMatiere> stockMatieres = new ArrayList<>();
        for (int i = 0; i<sacMatieres.size(); i++){
            for(Reste r : restes){
                if(r.getMat_id()==sacMatieres.get(i).getSacMatiere().getMat_id()){
                    if(r.getReste()-(sacMatieres.get(i).getSacMatiereQuantite()*quantite)>=0){
                        StockMatiere stockMatiere = new StockMatiere();
                        stockMatiere.setDateStockmat(date);
                        stockMatiere.setEtatStockmat(-1);
                        stockMatiere.setQuanStockmatSortie(sacMatieres.get(i).getSacMatiereQuantite());
                        stockMatiere.setQuanStockmatEntree(0);
                        stockMatiere.setMatStockmat(sacMatieres.get(i).getSacMatiere());
                        stockMatieres.add(stockMatiere);
                    } else {
                        model.addAttribute("error", "Quantite insuffisant");
                        return "main-component";
                    }
                }
            }
        }
        for(StockMatiere sm : stockMatieres){
            stockMatiereRepo.save(sm);
        }
        stockSacRepo.save(stockSac);
        return "main-component";
    }

    @GetMapping("/{value}")
    @ResponseBody
    public List<ResteStockSac> search(@PathVariable("value") String value){
        List<ResteStockSac> allReste = resteStockSac.findAllBySacNomLike(value);
        return allReste;
    }
}
