/*
 * Copyright (c) 2021 Javp_.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Javp_ - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.distribuidas.examen.controller;

import ec.edu.espe.distribuidas.examen.model.SegPerfil;
import ec.edu.espe.distribuidas.examen.service.SegPerfilService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javp_
 */
@RestController
@Slf4j
@RequestMapping("/v1/perfil")
public class SegPerfilController {

    private final SegPerfilService service;

    public SegPerfilController(SegPerfilService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Obtener todos las identificaciones de una persona",
            notes = "Obtiene los datos basicos de la base de datos",
            response = SegPerfil.class, hidden = false)
    @ApiResponses(value = {
        @ApiResponse(code = 200,
                message = "Retorna una lista de identificaciones de la persona o vacía si no existe ninguno en la base",
                response = SegPerfil.class,
                responseContainer = "List"),
        @ApiResponse(code = 404,
                message = "Retorna una lista de identificaciones de la persona o vacía si no existe ninguno en la base",
                response = SegPerfil.class,
                responseContainer = "List")
    })
    public ResponseEntity obtenerPerfilesAct() {
        List<SegPerfil> perfiles = this.service.listarPerfilAct("ACT");
        return ResponseEntity.ok(perfiles);
    }

    
    
}
