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
import ec.edu.espe.distribuidas.examen.exception.CreateException;
import ec.edu.espe.distribuidas.examen.model.SegPerfil;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javp_
 */
@Service
@Slf4j
public class SegPerfilService {
    
    private final SegPerfilRepository repo;

    public SegPerfilService(SegPerfilRepository repo) {
        this.repo = repo;
    }
    
    public List<SegPerfil> listarPerfilAct(String estado) {
        return this.repo.findByEstadoOrderByNombre(estado);
    }

}
