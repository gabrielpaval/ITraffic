package ro.proiect.iTraffic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.proiect.iTraffic.Models.Tarife;
import ro.proiect.iTraffic.Models.Trasee;
import ro.proiect.iTraffic.Service.TraseuService;

@RestController
@RequestMapping(path="/api/v2/traseu")
public class TraseuController {

    @Autowired
    private TraseuService traseuService;

    @GetMapping(value = "/all")
    public ResponseEntity getTrasee() {

        return traseuService.getAllContent();
    }
    @PostMapping("/add")
    public ResponseEntity addTarif(@RequestBody Trasee traseu)
    {
        return traseuService.addTraseu(traseu);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTarifbyId(@PathVariable Long id)
    {
        return traseuService.getTraseu(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTarif(@RequestBody Trasee traseu, @PathVariable Long id) {
        return traseuService.updateTraseu(traseu, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTraseu(@PathVariable Long id) {
        return traseuService.deleteTraseu(id);
    }
}
