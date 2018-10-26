/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.Paxi.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.Paxi.dao.FechaDaoI;
import pe.edu.upeu.Paxi.modelo.Fecha;
/**
 *
 * @author TOSHIBA
 */
@Service
@Transactional
public class FechaServicioImpl implements FechaServicioI{
    @Autowired
    public FechaDaoI dao;
    
    @Override
    public List<Fecha> listarEntidad(){return dao.listarEntidad();}
    @Override
    public Fecha buscarEntidadId(int id){return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(Fecha fecha){dao.guardarEntidad(fecha);}
    @Override
    public void eliminarEntidad(int id){dao.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(Fecha fecha){dao.modificarEntidad(fecha);}
}
