<!DOCTYPE html>
<%@page import="vz.hackathon.logic.Reassign"%>
<%@page import="vz.hackathon.logic.EmployeeInfo"%>
<%@page import="vz.hackathon.helper.SQLHelper"%>
<%@page import="vz.hackathon.helper.Identifier"%>
<%@page import="javax.websocket.Session"%>
<%@page import="java.sql.*"%>

<html lang="en">

<head>
<%@ page import="vz.hackathon.servlet.*" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Zepthy</title>
<!-- popup css -->
	<link href="../dist/css/popup.css" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif] -->


    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script>
    $(document).ready(
            function() {
                setInterval(function() {
                    var randomnumber = Math.floor(Math.random() * 100);
                    //populate();
                    //$('#morris-donut-chart').text;
                }, 3000);
            });
</script>

</head>

<body >

    <div id="wrapper" >

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Intelligent Task Management System</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
  
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
  		        <li class="divider"></li>
                        <li><a href="index.html" ><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
<% int num=0; 
	SQLHelper help=new SQLHelper();
	
	ResultSet rs=help.SELECT("reassign", "count(*)", "manager_id="+session.getAttribute("emp_id").toString());
	if(rs.next())
	num=rs.getInt("count(*)");
%>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="dashboard.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="team.jsp"><i class="fa fa-dashboard fa-fw"></i> Team View</a>
                        </li>
                        <li>
                            <a href="reassign.jsp"><i class="fa fa-edit fa-fw"></i> Reassign Tasks [<% out.print(num); %>]</p></a>
                        </li>
                        <li>
                            <a href="forms.jsp"><i class="fa fa-edit fa-fw"></i> Create Task</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Blank</h1>
                 </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                                <!-- Employee task table -->
                <% EmployeeInfo einfo= new EmployeeInfo(); 
                Reassign rinfo=new Reassign();
                	String id=session.getAttribute("emp_id").toString();
                %>
                  <div class="col-lg-12" id="mytask" style="float: right; " >
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            My Tasks
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example" >
                                    <thead>
                                        <tr>
                                            <th>Task Name</th>
                                            <th>Task Id</th>
                                            <th>Assigned On</th>
                                            <th>Deadline</th>
                                            <th>Priority</th>
                                            <th>Hours Recommended / week</th>
                                             <th>Task Status</th>
                                             <th>Reassign</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <% 
                                    String prnt=rinfo.reassign(id);
                                    	out.print(prnt);
                                    	
                                    %>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
 
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                
               
                
                
                <!--  /.Employee task table -->
                
                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    
    <script type="text/javascript">
	function reassign(taskid)
	{
	
	$.ajax({
	    type: "GET",
	    url: "../ReassignServlet",
	    data:{
	    	server_task_id:taskid,
	    	
	    },
	    success: function(data) {
	    	alert("Reassigned");
	    	
	        $('#results').html(data);
	    }
	});
}
    
    
    </script>

</body>

</html>
