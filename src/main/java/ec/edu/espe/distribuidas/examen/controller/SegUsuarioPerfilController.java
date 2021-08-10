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

import ec.edu.espe.distribuidas.examen.dto.SegUsuarioPerfilRQ;
import ec.edu.espe.distribuidas.examen.model.SegPerfil;
import ec.edu.espe.distribuidas.examen.service.SegUsuarioPerfilService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import static java.lang.StrictMath.log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javp_
 */
@RestController
@Slf4j
@RequestMapping("/v1/perfilUsuario")
public class SegUsuarioPerfilController {

    private final SegUsuarioPerfilService service;

    public SegUsuarioPerfilController(SegUsuarioPerfilService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Crea un perfil para un usuario con omisión YES",
            notes = "Crea un perfil para un usuario con omisión YES",
            response = SegPerfil.class, hidden = false)
    @ApiResponses(value = {
        @ApiResponse(code = 200,
                message = "Ingresa un perfil a un usuario",
                response = SegPerfil.class,
                responseContainer = "List")
    })
    public ResponseEntity createPerfilUsuario(@RequestBody SegUsuarioPerfilRQ segUsuarioPerfilRQ) {
        try {
            this.service.crearPerfil(segUsuarioPerfilRQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ocurrio un error al crear el perfil usuario. {} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

//    @PostMapping
//    public ResponseEntity createPerfilUsuario(@RequestBody SegUsuarioPerfilRQ segUsuarioPerfilRQ) {
//        try {
//            this.service.crearPerfil(segUsuarioPerfilRQ);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            log.error("Ocurrio un error al crear los perfiles de usuario. {} - retorna badrequest", e.getMessage());
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
