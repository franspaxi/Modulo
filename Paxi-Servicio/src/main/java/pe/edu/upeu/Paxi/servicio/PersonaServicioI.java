/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.Paxi.servicio;

import java.util.List;
import pe.edu.upeu.Paxi.modelo.Persona;
/**
 *
 * @author TOSHIBA
 */
public interface PersonaServicioI {
    public List<Persona> listarEntidad();
    public List<Persona> listarEntidadDato(String dato);
    public Persona buscarEntidadId(int id);
    public void guardarEntidad(Persona persona);
    public void eliminarEntidad(int id);
    public void modificarEntidad(Persona persona);    
}