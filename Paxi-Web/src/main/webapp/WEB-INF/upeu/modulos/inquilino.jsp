<%-- 
    Document   : inquilino
    Created on : 16-sep-2018, 17:40:02
    Author     : TOSHIBA
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src='/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js'></script>
<link rel="stylesheet" href="/resources/css/jquery.dataTables.min.css">
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      <spring:message code="welcome.inquilino" arguments="${startMeeting}" />
      <small>>_<</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
      <li class="active">Here</li>
      <li class="active"><a href="/pers" class="btn btn-warning">Ir Persona</a></li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">

    <!-- Your Page Content Here -->

    Idioma: <a href="?lang=en">Ingles</a> | <a href="?lang=fr">Frances</a> | <a href="?lang=es">Espa�ol</a><br/> 
    Mensaje: 
    ${message} <br/>               
    <p> <spring:message code="welcome.inquilino" arguments="${startMeeting}" /> </p> 
    <br/>
          <div class="box">
          <div class="box-body">
            <form action="${pageContext.request.contextPath}/buscar" method="POST">

            <div class="form-group">
                <label class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control"  id="dato" name="dato"/>                     
                </div>                
                <div class="col-sm-1">
                    <input type="submit" value="Buscar" class="btn btn-primary"/>
                </div>
                <div class="col-sm-1">
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/formPersona">Nuevo</a>  
                </div>
            </div>
              </form>
          </div>
          </div>        
    <c:if test="${!empty ListaPersona}">
        <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Reporte de Inquilinos</h3>                                    
                </div><!-- /.box-header -->        
        <div class="box-body table-responsive">
        <table id="example1" class="table table-bordered table-striped">
          <thead >
            <tr>
              <th>idPersona</th>
              <th>Nombre</th>
              <th>Apellidos</th>
              <th>DNI</th>
              <th>Telefono</th>
              <th>Carrera</th>
              <th>Opciones</th>
            </tr>
          </thead>
          <tbody>
                <c:forEach items="${ListaPersona}" var="dato">
                      <tr>
                        <th>${dato.idpersona}</th>
                        <td>${dato.nombre}</td>
                        <td>${dato.apellido}</td>
                        <td>${dato.dni}</td>
                        <td>${dato.telefono}</td>
                        <td>${dato.carrera}</td>
                        <td><a href="${pageContext.request.contextPath}/elim?id=${dato.idpersona}">E</a></td>
                      </tr>
              </c:forEach> 
            </tbody>
            <tfoot>
                <tr>
                <th>IdPersona</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>DNI</th>
                <th>Telefono</th>
                <th>Carrera</th>
                <th>Opciones</th>
                </tr>
            </tfoot>            
          </table>  
          </div>
        </div>                                
          </c:if>                   
  </section><!-- /.content -->  

</div><!-- /.content-wrapper -->
<script>
  $(function () {
    $('#example1').DataTable();
//    $('#example2').DataTable({
//      'paging'      : true,
//      'lengthChange': true,
//      'searching'   : true,
//      'ordering'    : true,
//      'info'        : true,
//      'autoWidth'   : false
//    });
  });
</script>