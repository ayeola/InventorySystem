

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <!-- Core CSS - Include with every page -->
    
    <link href="<c:url value="/bs-siminta-admin/assets/plugins/bootstrap/bootstrap.css"/>" rel="stylesheet" />
    <link href="<c:url value="/bs-siminta-admin/assets/font-awesome/css/font-awesome.css"/>" rel="stylesheet" />
    <link href="<c:url value="/bs-siminta-admin/assets/plugins/pace/pace-theme-big-counter.css"/>" rel="stylesheet" />
    <link href="<c:url value="/bs-siminta-admin/assets/css/style.css"/>" rel="stylesheet" />
    <link href="<c:url value="/bs-siminta-admin/assets/css/main-style.css"/>" rel="stylesheet" />
    <!-- Page-Level CSS -->
    <link href="<c:url value="/bs-siminta-admin/assets/plugins/morris/morris-0.4.3.min.css"/>" rel="stylesheet" />
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
                <!-- Page Header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!--End Page Header -->
            </div>

            <%@include file="userPanel.jsp" %>


            <div class="row">
                <!--quick info section -->
                <div class="col-lg-3">
                    <div class="alert alert-danger text-center">
                        <i class="fa fa-calendar fa-3x"></i>&nbsp;<b>20 </b>Meetings Sheduled This Month

                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="alert alert-success text-center">
                        <i class="fa  fa-beer fa-3x"></i>&nbsp;<b>27 % </b>Profit Recorded in This Month  
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="alert alert-info text-center">
                        <i class="fa fa-rss fa-3x"></i>&nbsp;<b>1,900</b> New Subscribers This Year

                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="alert alert-warning text-center">
                        <i class="fa  fa-pencil fa-3x"></i>&nbsp;<b>2,000 $ </b>Payment Dues For Rejected Items
                    </div>
                </div>
                <!--end quick info section -->
            </div>

            <div class="row">
                <div class="col-lg-8">



                    <!--Area chart example -->
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i>Area Chart Example
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                        Actions
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu pull-right" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel-body">
                            <div id="morris-area-chart"></div>
                        </div>

                    </div>
                    <!--End area chart example -->
                    <!--Simple table example -->
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i>Simple Table Example
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                        Actions
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu pull-right" role="menu">
                                        <li><a href="#">Action</a>
                                        </li>
                                        <li><a href="#">Another action</a>
                                        </li>
                                        <li><a href="#">Something else here</a>
                                        </li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Date</th>
                                                    <th>Time</th>
                                                    <th>Amount</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>3326</td>
                                                    <td>10/21/2013</td>
                                                    <td>3:29 PM</td>
                                                    <td>$321.33</td>
                                                </tr>
                                                <tr>
                                                    <td>3325</td>
                                                    <td>10/21/2013</td>
                                                    <td>3:20 PM</td>
                                                    <td>$234.34</td>
                                                </tr>
                                                <tr>
                                                    <td>3324</td>
                                                    <td>10/21/2013</td>
                                                    <td>3:03 PM</td>
                                                    <td>$724.17</td>
                                                </tr>
                                                <tr>
                                                    <td>3323</td>
                                                    <td>10/21/2013</td>
                                                    <td>3:00 PM</td>
                                                    <td>$23.71</td>
                                                </tr>
                                                <tr>
                                                    <td>3322</td>
                                                    <td>10/21/2013</td>
                                                    <td>2:49 PM</td>
                                                    <td>$8345.23</td>
                                                </tr>


                                            </tbody>
                                        </table>
                                    </div>

                                </div>

                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!--End simple table example -->

                </div>

                <div class="col-lg-4">
                    <div class="panel panel-primary text-center no-boder">
                        <div class="panel-body yellow">
                            <i class="fa fa-bar-chart-o fa-3x"></i>
                            <h3>20,741 </h3>
                        </div>
                        <div class="panel-footer">
                            <span class="panel-eyecandy-title">Daily User Visits
                            </span>
                        </div>
                    </div>
                    <div class="panel panel-primary text-center no-boder">
                        <div class="panel-body blue">
                            <i class="fa fa-pencil-square-o fa-3x"></i>
                            <h3>2,060 </h3>
                        </div>
                        <div class="panel-footer">
                            <span class="panel-eyecandy-title">Pending Orders Found
                            </span>
                        </div>
                    </div>
                    <div class="panel panel-primary text-center no-boder">
                        <div class="panel-body green">
                            <i class="fa fa fa-floppy-o fa-3x"></i>
                            <h3>20 GB</h3>
                        </div>
                        <div class="panel-footer">
                            <span class="panel-eyecandy-title">New Data Uploaded
                            </span>
                        </div>
                    </div>
                    <div class="panel panel-primary text-center no-boder">
                        <div class="panel-body red">
                            <i class="fa fa-thumbs-up fa-3x"></i>
                            <h3>2,700 </h3>
                        </div>
                        <div class="panel-footer">
                            <span class="panel-eyecandy-title">New User Registered
                            </span>
                        </div>
                    </div>







                </div>

            </div>

            <%@include file="msgPanel.jsp" %>


         


        </div>
        <!-- end page-wrapper -->

    </div>
    <!-- end wrapper -->

    <!-- Core Scripts - Include with every page -->
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/jquery-1.10.2.js"/>"></script>
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/bootstrap/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/metisMenu/jquery.metisMenu.js"/>"></script>
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/pace/pace.js"/>"></script>
    <script src="<c:url value="/bs-siminta-admin/assets/scripts/siminta.js" />"></script>
    <!-- Page-Level Plugin Scripts-->
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/morris/raphael-2.1.0.min.js" />"></script>
    <script src="<c:url value="/bs-siminta-admin/assets/plugins/morris/morris.js"/>" ></script>
    <script src="<c:url value="/bs-siminta-admin/assets/scripts/dashboard-demo.js" />"></script>

</body>

</html>
