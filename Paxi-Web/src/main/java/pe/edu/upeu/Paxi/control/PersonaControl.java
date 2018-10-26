/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.Paxi.control;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pe.edu.upeu.Paxi.modelo.Persona;
import pe.edu.upeu.Paxi.modelo.Fecha;
import pe.edu.upeu.Paxi.modelo.Comida;
import pe.edu.upeu.Paxi.modelo.Total;
import pe.edu.upeu.Paxi.servicio.PersonaServicioI;
import pe.edu.upeu.Paxi.servicio.FechaServicioI;
import pe.edu.upeu.Paxi.servicio.ComidaServicioI;
import pe.edu.upeu.Paxi.servicio.TotalServicioI;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Controller
public class PersonaControl {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    PersonaServicioI personaServicioI;
    @Autowired
    FechaServicioI fechaServicioI;
    @Autowired
    ComidaServicioI comidaServicioI;
    @Autowired
    TotalServicioI totalServicioI;
    
    @RequestMapping(value = "/locate", method = RequestMethod.GET)
    public String getLocatePage(){
    return "my-locale";
    }
    
    
@RequestMapping(value = {"/" }, method = RequestMethod.GET)    
public ModelAndView inicio(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Frans Paxi"}, locale);
    List<Persona> lista=personaServicioI.listarEntidad();
    for (Persona persona : lista) {
        System.out.println("Nombres: "+persona.getNombre()+" "+persona.getApellido());
    }
    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("persona/mainPersona");
}

@RequestMapping(value = {"/inquilin" }, method = RequestMethod.GET)    
public ModelAndView inicioUno(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Frans Paxi"}, locale);
    List<Persona> lista=personaServicioI.listarEntidad();
    for (Persona persona : lista){
        System.out.println("Nosmbres: "+persona.getNombre()+""+persona.getApellido());
    } 
    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("inquilino");
}

@RequestMapping(value = {"/fech" }, method = RequestMethod.GET)    
public ModelAndView inicioDos(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Frans Paxi"}, locale);
    List<Fecha> lista=fechaServicioI.listarEntidad();
    for (Fecha fecha : lista){
        System.out.println("Nombres: "+fecha.getCosto()+""+fecha.getFechafin());
    } 
    model.put("ListaFecha", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("fecha");
}

@RequestMapping(value = {"/comid" }, method = RequestMethod.GET)    
public ModelAndView inicioTres(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Frans Paxi"}, locale);
    List<Comida> lista=comidaServicioI.listarEntidad();
    for (Comida comida : lista){
        System.out.println("Nombres: "+comida.getDesayuno()+""+comida.getAlmuerzo());
    } 
    model.put("ListaComida", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("comida");
}

@RequestMapping(value = {"/tota" }, method = RequestMethod.GET)    
public ModelAndView inicioCuatro(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Hola Señor Administrador"}, locale);
    List<Total> lista=totalServicioI.listarEntidad();
    for (Total total : lista){
        System.out.println("Nombres: "+total.getIdcomida()+""+total.getIdfecha());
    } 
    model.put("ListaTotal", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("total");
}

@RequestMapping(value = {"/elim" }, method = RequestMethod.GET)
public ModelAndView eliminarPersona(HttpServletRequest r){
    int idEntidad=Integer.parseInt(r.getParameter("id"));
    personaServicioI.eliminarEntidad(idEntidad);
return new ModelAndView(new RedirectView("/"));
}
  
@RequestMapping(value = {"/buscar"}, method = RequestMethod.POST)
public  ModelAndView buscarEntidad(Locale locale, Map<String,Object> model, HttpServletRequest r){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"David Mamani"}, locale);
    String dato=r.getParameter("dato");
    List<Persona> lista=personaServicioI.listarEntidadDato(dato);
    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");    
return new ModelAndView("persona/mainPersona");
}

@RequestMapping(value = "/formPersona", method = RequestMethod.GET)
public ModelAndView irFormulario(@ModelAttribute("modeloPersona")Persona persona,
        BindingResult result){
    
return new ModelAndView("persona/formPersona");
}

@RequestMapping(value = "/guardarPersona", method = RequestMethod.POST)
public ModelAndView guardarEntidad(@ModelAttribute("modeloPersona")Persona persona,
        BindingResult result){
        personaServicioI.guardarEntidad(persona);
    return new ModelAndView(new RedirectView("/"));
}

}
