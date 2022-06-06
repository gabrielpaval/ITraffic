package ro.proiect.iTraffic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.proiect.iTraffic.Models.Tarife;
import ro.proiect.iTraffic.Repository.TarifeRepository;

import java.util.Optional;

@Service
public class TarifService {

    @Autowired
    private TarifeRepository tarifeRepository;

    private String isValidAdd(Tarife tarif) {
        Optional<Tarife> optional = Optional.ofNullable(tarif);
        String response = "";
        if (optional.isPresent()) {
            if (tarifeRepository.existsById(tarif.getId()))
                response += "Fare with id <" + tarif.getId() + "> already exists.\n";
        }
        return response;
    }
    private String isValidUpdate(Tarife tarif) {
        Optional<Tarife> optional = Optional.ofNullable(tarif);
        String response = "";
        if (optional.isPresent()) {

             if (tarifeRepository.existsById(tarif.getId()) && tarifeRepository.countById(tarif.getId()) > 1)
                response += "Fare with id <" + tarif.getId() + "> already exists.\n";
              if (tarif.getPretAdulti() == 0)
                response += "";
            if (tarif.getPretElevi()== 0)
                response += "";
            if (tarif.getPretVarstnici() == 0)
                response += "";
            if (tarif.getPretCopii() == 0)
                response += "";
            if (tarif.getTip() == null)
                response +="";

        }
        return response;
    }
    public ResponseEntity addTarif(Tarife tarif){
        String response = isValidAdd(tarif);
        if (response == null || response.equals("")) {
            tarifeRepository.save(tarif);
            return new ResponseEntity<>("Fare with id <" + tarif.getId() + "> has been added.", HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity getTarife(){
        System.out.println(tarifeRepository.count());
        if(tarifeRepository.count()==0)
            return new ResponseEntity<>("There are no data", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(tarifeRepository.findAll(),HttpStatus.OK);
    }
    public ResponseEntity getTarif(Long id)
    {
        if (tarifeRepository.findById(id).orElse(null) != null)
            return new ResponseEntity<>(tarifeRepository.findById(id), HttpStatus.OK);
        return new ResponseEntity<>("We don't have a fare with id <" + id + ">.", HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity updateTarif(Tarife tarif, Long id) {
        Tarife existingTarif = tarifeRepository.findById(id).orElse(null);
        String response = isValidUpdate(tarif);
        if (existingTarif != null) {
            if (response == null || response.equals("")) {
                existingTarif.setPretAdulti(tarif.getPretAdulti());
                existingTarif.setPretCopii(tarif.getPretCopii());
                existingTarif.setPretElevi(tarif.getPretElevi());
                existingTarif.setTip(tarif.getTip());
                existingTarif.setPretVarstnici(tarif.getPretVarstnici());
                tarifeRepository.save(existingTarif);
                return new ResponseEntity<>("Fare with id <" + id + "> has been updated.", HttpStatus.OK);
            }
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Can't find fare with id <" + id + ">.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity deleteTarif(Long id) {
        if (tarifeRepository.existsById(id)) {
            tarifeRepository.deleteById(id);
            return new ResponseEntity<>("Fare with id <" + id + "> has been removed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't find room with id <" + id + ">.", HttpStatus.BAD_REQUEST);
    }
}
