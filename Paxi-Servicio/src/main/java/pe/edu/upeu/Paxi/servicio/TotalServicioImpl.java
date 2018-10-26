/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.Paxi.servicio;

import pe.edu.upeu.Paxi.dao.TotalDaoI;
import pe.edu.upeu.Paxi.modelo.Total;
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
public class TotalServicioImpl implements TotalServicioI{
     @Autowired
    public TotalDaoI dao;
    
    @Override
    public List<Total> listarEntidad(){return dao.listarEntidad();}
    @Override
    public Total buscarEntidadId(int id){return dao.buscarEntidadId(id);}
    @Override
    public void guardarEntidad(Total total){dao.guardarEntidad(total);}
    @Override
    public void eliminarEntidad(int id){dao.eliminarEntidad(id);}
    @Override
    public void modificarEntidad(Total total){dao.modificarEntidad(total);}
}