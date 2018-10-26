/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.Paxi.servicio;

import pe.edu.upeu.Paxi.modelo.Comida;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface ComidaServicioI {
    public List<Comida> listarEntidad();
    public Comida buscarEntidadId(int id);
    public void guardarEntidad(Comida comida);
    public void eliminarEntidad(int id);
    public void modificarEntidad(Comida comida);
}
