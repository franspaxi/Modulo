/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.Paxi.servicio;

import pe.edu.upeu.Paxi.dao.ComidaDaoI;
import pe.edu.upeu.Paxi.modelo.Comida;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TOSHIBA
 */
@Service
@Transactional
public class ComidaServicioImpl implements ComidaServicioI{
     @Autowired
    public ComidaDaoI dao;
    
    @Override
    public List<Comida> listarEntidad(){return dao.listarEntidad();}
    @Override
    public Comida buscarEntidadId(int id){return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(Comida comida){dao.guardarEntidad(comida);}
    @Override
    public void eliminarEntidad(int id){dao.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(Comida comida){dao.modificarEntidad(comida);}
}
