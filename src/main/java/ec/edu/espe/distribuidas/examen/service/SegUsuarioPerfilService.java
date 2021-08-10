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
package ec.edu.espe.distribuidas.examen.service;

import ec.edu.espe.distribuidas.examen.dao.SegPerfilRepository;
import ec.edu.espe.distribuidas.examen.dao.SegUsuarioPerfilRepository;
import ec.edu.espe.distribuidas.examen.dao.SegUsuarioRepository;
import ec.edu.espe.distribuidas.examen.dto.SegUsuarioPerfilRQ;
import ec.edu.espe.distribuidas.examen.model.SegPerfil;
import ec.edu.espe.distribuidas.examen.model.SegUsuario;
import ec.edu.espe.distribuidas.examen.model.SegUsuarioPerfil;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Javp_
 */
@Service
@Slf4j
public class SegUsuarioPerfilService {

    private final SegPerfilRepository segPerfilRepository;
    private final SegUsuarioPerfilRepository segUsuarioPerfilRepository;
    private final SegUsuarioRepository segUsuarioRepository;

    public SegUsuarioPerfilService(SegPerfilRepository segPerfilRepository, SegUsuarioPerfilRepository segUsuarioPerfilRepository, SegUsuarioRepository segUsuarioRepository) {
        this.segPerfilRepository = segPerfilRepository;
        this.segUsuarioPerfilRepository = segUsuarioPerfilRepository;
        this.segUsuarioRepository = segUsuarioRepository;
    }

    @Transactional
    public void crearPerfiles(SegUsuarioPerfilRQ segUsuarioPerfilRQ) {
        Optional<SegUsuario> segUsuario = this.segUsuarioRepository.findById(segUsuarioPerfilRQ.getCodUsuario());
        Optional<SegPerfil> segPerfil = this.segPerfilRepository.findById(segUsuarioPerfilRQ.getCodPerfil());
        SegUsuarioPerfil suP = new SegUsuarioPerfil(segUsuario.get().getCodUsuario(), segPerfil.get().getCodPerfil());

        suP.setSegUsuario(segUsuario.get());
        suP.setSegPerfil(segPerfil.get());
        suP.setEstado(segUsuarioPerfilRQ.getEstado());
        suP.setPorOmision("Y");

        log.info("Perfil: {}", suP.getSegUsuario());
        this.segUsuarioPerfilRepository.save(suP);
    }
}
