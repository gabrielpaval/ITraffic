package ro.proiect.iTraffic.Service;


import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.proiect.iTraffic.Repository.TraseeRepository;

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

}
