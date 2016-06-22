<%-- 
    Document   : CreateNonTeachingStaff
    Created on : Jun 15, 2016, 11:10:57 AM
    Author     : Abiodun.Ayeola
--%>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Non Teaching Staff</title>
    <!-- Core CSS - Include with every page -->
    <link href="<c:url value="/bs-siminta-admin/assets/plugins/bootstrap/bootstrap.css"/>" rel="stylesheet" />
    <link href="<c:url value="/bs-siminta-admin/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
    <link href="<c:url value="/bs-siminta-admin/assets/plugins/pace/pace-theme-big-counter.css"/>" rel="stylesheet" />
    <link href="<c:url value="/bs-siminta-admin/assets/css/style.css"/>" rel="stylesheet" />
    <link href="<c:url value="/bs-siminta-admin/assets/css/main-style.css"/>" rel="stylesheet" />
    
    <style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
    
    </head>
    
    
    <body>
    <!--  wrapper -->
    <div id="wrapper">
        <!-- navbar top -->
        <%@include file="topBar.jsp" %>
        <!-- end navbar top -->

        <!-- navbar side -->
        <%@include file="sideBar.jsp" %>
        <!-- end navbar side -->
        <!--  page-wrapper -->
          <div id="page-wrapper">
            <div class="row">
                 <!-- page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Forms</h1>
                </div>
                <!--end page header -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <!-- Form Elements -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Create New NTS
                        </div>
                        
                        <div style="color: green; font-size: larger;font-style: normal;font-family: monospace">
                                        ${message}
                                        <c:choose>
<c:when test="${not empty  errors}">
    <div class="error">
    <c:forEach items="${errors}" var="err">
        ${err.defaultMessage}
        <br/>
    </c:forEach>
    </div>
</c:when>
</c:choose>
                                    </div>
                        
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" method="post" action="/InventorySystem/addNonTeachingStaff">
                                        
                                      <div class="form-group has-success">
                                            <label class="control-label" for="registrationNumber">Staff Registration Number</label>
                                            <input type="text" class="form-control" name="registrationNumber" id="registrationNumber">
                                        </div>                                                                                                                                                                
                                        <div class="form-group has-success">
                                            <label class="control-label" for="firstName">First Name</label>
                                            <input type="text" class="form-control" name="firstName" id="firstName">
                                        </div>                                                                                                                                                                
                                        <div class="form-group has-success">
                                            <label class="control-label" for="middleName">Middle Name</label>
                                            <input type="text" class="form-control" name="middleName" id="middleName">
                                        </div>                                                                                                                                                                
                                        <div class="form-group has-success">
                                            <label class="control-label" for="lastName">Last Name</label>
                                            <input type="text" class="form-control" name="lastName" id="password">
                                        </div>                                                                                                                                                                
                                        <div class="form-group has-success">
                                            <label class="control-label" for="email">Email</label>
                                            <input type="text" class="form-control" name="email" id="email">
                                        </div>                                                                                                                                                                
                                        <div class="form-group has-success">
                                            <label class="control-label" for="phoneNumber">Phone Number</label>
                                            <input type="text" class="form-control" name="phoneNumber" id="phoneNumber">
                                        </div>                                                                                                                                                                                                                                                                                                                                                                        
                                        
                                        <div class="form-group">
                                            <label>Tittle</label>
                                            <select class="form-control" name="title">
                                                <option value="-1"><----Please select from the list-------></option>
                                                <option value="Mr">Mr</option>
                                                <option value="Mrs">Mrs</option>                                                
                                                <option value="Miss">Miss</option>                                                
                                                <option value="Dr">Dr</option>                                                
                                                <option value="Engr">Engr</option>                                                
                                            </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Gender</label>
                                            <select class="form-control" name="gender">
                                                <option value="-1"><----Please select from the list-------></option>
                                                <option value="Male">Male</option>
                                                <option value="Female">Female</option>                                                
                                            </select>
                                        </div>
                                        
                                        <button type="submit" class="btn btn-primary">Submit Button</button>
                                        <button type="reset" class="btn btn-success">Reset Button</button>
                                    </form>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                     <!-- End Form Elements -->
                </div>
            </div>
        </div>
        <!-- end page-wrapper -->

    </div>
    <!-- end wrapper -->

    <!-- Core Scripts - Include with every page -->
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/jquery-1.10.2.js"/>"></script>
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/bootstrap/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/metisMenu/jquery.metisMenu.js"/>"></script>
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/pace/pace.js"/>"></script>
    <script src="<c:url value="/bs-siminta-admin/assets/scripts/siminta.js"/>"></script>

</body>
</html>

