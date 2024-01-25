package com.project.project.Controller;

import com.project.project.Model.*;
import com.project.project.Model.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/achat")
public class AchatController {
    @Autowired
    private ResteStockSacRepo resteStockSacRepo;
    @Autowired
    private SacRepo sacRepo;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private VenteRepo venteRepo;
    @Autowired
    private StockSacRepo stockSacRepo;
    @GetMapping
    public String toAchat(Model model, HttpServletRequest request){
        model.addAttribute("page", "achat");
        model.addAttribute("title", "Achat");
        List<Sac> allSac = sacRepo.findAll();
        List<Client> allClient = clientRepo.findAll();
        request.setAttribute("sacs", allSac);
        request.setAttribute("clients", allClient);
        return "main-component";
    }

    @PostMapping
    public String vente(@RequestParam("client_id") int client_id, @RequestParam("sac_id") int sac_id, @RequestParam("quan") double quant, Model model, HttpServletRequest request){
        ResteStockSac r = resteStockSacRepo.findById(sac_id).get();
        model.addAttribute("page", "achat");
        model.addAttribute("title", "Achat");
        List<Sac> allSac = sacRepo.findAll();
        List<Client> allClient = clientRepo.findAll();
        request.setAttribute("sacs", allSac);
        request.setAttribute("clients", allClient);
        if(r.getReste()-quant<0){
            model.addAttribute("error", "Quantite insuffisant: en stock "+r.getReste());
            return "main-component";
        }
        Client c = new Client();
        c.setIdClient(client_id);
        Sac s = new Sac();
        s.setSacId(sac_id);
        Vente v = new Vente();
        v.setClient(c);
        v.setSac(s);
        v.setDate(new Date());
        v.setQuantite(quant);
        venteRepo.save(v);
        StockSac stockSac = new StockSac();
        stockSac.setQuanStockEntre(0);
        stockSac.setQuanStockSortie(quant);
        stockSac.setSacStock(s);
        stockSac.setEtatStock(-1);
        stockSacRepo.save(stockSac);
        return "main-component";
    }
}
