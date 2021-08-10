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
package ec.edu.espe.distribuidas.examen.dto;

import ec.edu.espe.distribuidas.examen.model.SegPerfil;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Javp_
 */
@Data
public class SegUserPerfilRQ {

    private String codUsuario;
    private String codPerfil;
    private String estado;
    
    private List<SegPerfil> perfiles;
}
