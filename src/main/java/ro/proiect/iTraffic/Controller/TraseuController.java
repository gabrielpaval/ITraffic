package ro.proiect.iTraffic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
