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
import ec.edu.espe.distribuidas.examen.service.SegUsuarioPerfilService;
import static java.lang.StrictMath.log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createPersonaIdentificacion(@RequestBody SegUsuarioPerfilRQ segUsuarioPerfilRQ) {
        try {
//            PerPersonaIdentificacion ppi = new PerPersonaIdentificacion(perPersonaIdentificacionRQ.getCodPersona(), perPersonaIdentificacionRQ.getCodTipoIdentificacion());
//            Optional<PerPersona> persona = this.personaService.obtenerPorCodigo(perPersonaIdentificacionRQ.getCodPersona());
//            log.error("Ocurrio un error al crear la perIdentificacion. {} - retorna badrequest", e.getMessage());
            this.service.crearPerfiles(segUsuarioPerfilRQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ocurrio un error al crear la perIdentificacion. {} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
