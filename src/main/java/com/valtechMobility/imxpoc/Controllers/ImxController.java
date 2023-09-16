package com.valtechMobility.imxpoc.Controllers;

import java.util.List;
import java.util.Optional;

import com.valtechMobility.imxpoc.Entities.ImxEntityClass;
import com.valtechMobility.imxpoc.Interfaces.ImxRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carbrands")
@CrossOrigin(origins = "*") // Adjust the origin as needed
public class ImxController {

    private final ImxRepository imxRepository;

    @Autowired
    public ImxController(ImxRepository imxRepository) {
        this.imxRepository = imxRepository;
    }

    @GetMapping
    public List<ImxEntityClass> getAllCarBrands() {
        return imxRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ImxEntityClass> getCarBrandById(@PathVariable Long id) {
        Optional<ImxEntityClass> carBrand = imxRepository.findById(id);
        return carBrand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<ImxEntityClass> createCarBrand(@RequestBody ImxEntityClass carBrand) {
        ImxEntityClass savedCarBrand = imxRepository.save(carBrand);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCarBrand);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ImxEntityClass> updateCarBrand(@PathVariable Long id, @RequestBody ImxEntityClass carBrand) {
        if (!imxRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        carBrand.setId(id);
        ImxEntityClass updatedCarBrand = imxRepository.save(carBrand);
        return ResponseEntity.ok(updatedCarBrand);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarBrand(@PathVariable Long id) {
        if (!imxRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        imxRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}