package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.domain.model.entities.Model;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.ModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/models")
public class ModelController {
    private final ModelRepository modelRepository;

    public ModelController(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Long> uploadModel(@RequestParam("file") MultipartFile file) {
        try {
            // Convert the MultipartFile to a byte[]
            byte[] data = file.getBytes();

            // Create a new Model entity with the file data
            Model model = new Model(data);

            // Save the Model entity
            Model savedModel = modelRepository.save(model);

            // Return the id of the saved Model
            return ResponseEntity.ok(savedModel.getId());
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Model> getModel(@PathVariable("id") Long id) {
        // Get the Model entity by id
        Model model = modelRepository.findById(id).orElseThrow(() -> new RuntimeException("Model not found"));

        // Return the Model entity
        return ResponseEntity.ok(model);
    }

}
