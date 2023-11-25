package com.furnigo.furniture.interfaces.rest.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furnigo.furniture.domain.model.entities.Design;
import com.furnigo.furniture.domain.services.DesignQueryService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value="/api/v1/design")
public class DesignController {
    private final DesignQueryService designQueryService;

    public DesignController(DesignQueryService designQueryService) {
        this.designQueryService = designQueryService;
    }

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @Transactional
    public ResponseEntity<byte[]> download(@PathVariable Long orderId){
        Design findedDesign = designQueryService.getDesignFromOrder(orderId)
            .orElseThrow(()-> new RuntimeException("Design not found"));

        byte[] data = findedDesign.getObjFile();

        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
