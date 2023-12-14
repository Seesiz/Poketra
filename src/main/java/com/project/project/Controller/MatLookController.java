package com.project.project.Controller;

import com.project.project.Model.Look;
import com.project.project.Model.Matiere_Look;
import com.project.project.Model.repository.MatiereLookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/matlook")
public class MatLookController {
    @Autowired
    private MatiereLookRepo matlookRepo;

    @GetMapping("/{idLook}")
    @ResponseBody
    public List<Matiere_Look> getByLook(@PathVariable("idLook") int idLook){
        Look l = new Look();
        l.setLookId(idLook);
        return matlookRepo.getAllByMatdetLook(l);
    }
}
