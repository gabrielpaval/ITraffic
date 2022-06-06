package ro.proiect.iTraffic.Service;


import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.proiect.iTraffic.Models.Tarife;
import ro.proiect.iTraffic.Models.Trasee;
import ro.proiect.iTraffic.Repository.TraseeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Setter
@Transactional
public class TraseuService {

    @Autowired
    private TraseeRepository traseuRepository;

    public ResponseEntity getAllContent(){
        System.out.println(traseuRepository.count());
        if(traseuRepository.count()==0)
            return new ResponseEntity<>("There are no data", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(traseuRepository.findAll(),HttpStatus.OK);
    }
    private String isValidAdd(Trasee traseu) {
        Optional<Trasee> optional = Optional.ofNullable(traseu);
        String response = "";
        if (optional.isPresent()) {
            if (traseuRepository.existsById(traseu.getId()))
                response += "Route with id <" + traseu.getId() + "> already exists.\n";
        }
        return response;
    }
    private String isValidUpdate(Trasee traseu) {
        Optional<Trasee> optional = Optional.ofNullable(traseu);
        String response = "";
        if (optional.isPresent()) {

            if (traseuRepository.existsById(traseu.getId()) && traseuRepository.countById(traseu.getId()) > 1)
                response += "Route with id <" + traseu.getId() + "> already exists.\n";
            if (traseu.getIdOrare() == 0)
                response += "";
            if (traseu.getIdStatii()== null)
                response += "";
            if (traseu.getLinie() == null)
                response +="";

        }
        return response;
    }

    public ResponseEntity addTraseu(Trasee traseu){
        String response = isValidAdd(traseu);
        if (response == null || response.equals("")) {
            traseuRepository.save(traseu);
            return new ResponseEntity<>("Route with id <" + traseu.getId() + "> has been added.", HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity getTraseu(Long id)
    {
        if (traseuRepository.findById(id).orElse(null) != null)
            return new ResponseEntity<>(traseuRepository.findById(id), HttpStatus.OK);
        return new ResponseEntity<>("We don't have a route with id <" + id + ">.", HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity updateTraseu(Trasee traseu, Long id) {
        Trasee existingTraseu = traseuRepository.findById(id).orElse(null);
        String response = isValidUpdate(traseu);
        if (existingTraseu != null) {
            if (response == null || response.equals("")) {
                existingTraseu.setLinie(traseu.getLinie());
                existingTraseu.setIdOrare(traseu.getIdOrare());
                existingTraseu.setIdStatii(traseu.getIdStatii());
                traseuRepository.save(existingTraseu);
                return new ResponseEntity<>("Route with id <" + id + "> has been updated.", HttpStatus.OK);
            }
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Can't find route with id <" + id + ">.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity deleteTraseu(Long id) {
        if (traseuRepository.existsById(id)) {
            traseuRepository.deleteById(id);
            return new ResponseEntity<>("Route with id <" + id + "> has been removed.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't find route with id <" + id + ">.", HttpStatus.BAD_REQUEST);
    }


}
