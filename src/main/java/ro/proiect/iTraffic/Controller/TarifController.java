package ro.proiect.iTraffic.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.proiect.iTraffic.Models.Tarife;
import ro.proiect.iTraffic.Service.TarifService;

@RestController
@RequestMapping(path="/api/v2/tarife")
public class TarifController {

    @Autowired
    private TarifService tarifService;

    @PostMapping("/add")
    public ResponseEntity addTarif(@RequestBody Tarife tarif)
    {
        return tarifService.addTarif(tarif);
    }
    @GetMapping("/all")
    public ResponseEntity getAll(){
        return tarifService.getTarife();
    }

    @GetMapping("/{id}")
    public ResponseEntity getTarifbyId(@PathVariable Long id)
    {
        return tarifService.getTarif(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTarif(@RequestBody Tarife tarif, @PathVariable Long id) {
        return tarifService.updateTarif(tarif, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTarif(@PathVariable Long id) {
        return tarifService.deleteTarif(id);
    }


}
