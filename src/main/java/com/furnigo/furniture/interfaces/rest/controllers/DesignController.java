package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.domain.services.DesignCommandService;
import com.furnigo.furniture.domain.services.DesignQueryService;
import com.furnigo.furniture.interfaces.rest.resources.CreateNewDesignResource;
import com.furnigo.furniture.interfaces.rest.resources.DeleteDesignResource;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/design", produces = "application/json")
public class DesignController {
    private final DesignCommandService designCommandService;
    private final DesignQueryService designQueryService;

    public DesignController(DesignCommandService designCommandService, DesignQueryService designQueryService) {
        this.designCommandService = designCommandService;
        this.designQueryService = designQueryService;
    }

    @PostMapping("/create")
    @Transactional
    public void createDesign(@RequestBody CreateNewDesignResource resource)
    {
        designCommandService.createDesign(resource);
        // Return the id of the design ??
    }

    @DeleteMapping("/remove")
    @Transactional
    public void deleteDesign(@RequestBody DeleteDesignResource resource)
    {
        designCommandService.deleteDesign(resource);
    }
}
