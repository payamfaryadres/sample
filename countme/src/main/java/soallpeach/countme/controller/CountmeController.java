package soallpeach.countme.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class CountmeController {

    Set<Long> numbers = new HashSet<>();
    @PostMapping
    public ResponseEntity sumNumber(@RequestBody String request){
         addNumberToSet(Long.valueOf(request.substring(0,request.length()-1)));
        return ResponseEntity.ok().build();
    }

    protected void addNumberToSet(Long number){
        numbers.add(number);
    }

    @RequestMapping(path = "/count")
    public ResponseEntity getCount(){
        return ResponseEntity.ok(numbers.parallelStream().mapToLong(Long::longValue).sum());
    }

}
