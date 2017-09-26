package br.com.library.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.library.domain.Magazine;
import br.com.library.service.MagazineService;

@RestController
@RequestMapping("/magazine")
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Magazine>> list() {

        return new ResponseEntity<List<Magazine>>((List<Magazine>) magazineService.listAllMagazine(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Magazine> showMagazine(@PathVariable Long id) {

        return new ResponseEntity<Magazine>(magazineService.getMagazineById(id), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public String saveMagazine(@RequestBody Magazine magazine) {
        return magazineService.saveMagazine(magazine);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteMagazine(@PathVariable Long id) {
        magazineService.deleteMagazine(id);
        return "redirect:/magazines";
    }
}
