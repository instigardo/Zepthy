<!DOCTYPE html>
<%@page import="vz.hackathon.helper.SQLHelper"%>
<%@page import="vz.hackathon.logic.EmployeeInfo"%>
<%@page import="vz.hackathon.helper.Identifier"%>
<html lang="en">

<head>
<%@ page import="vz.hackathon.servlet.*" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Zepthy</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="../dist/css/timeline.css" rel="stylesheet">
    
        <!-- DataTables CSS -->
    <link href="../bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">
    

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

<body>

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

            <!-- <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="dashboard.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="team.jsp"><i class="fa fa-dashboard fa-fw"></i> Team View</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Create Task</a>
                        </li>
                    </ul>
                </div>
                
            </div> -->
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper" style="margin: 0 0 0 0">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <% MorrisPopulator pMorris=new MorrisPopulator(); 
 Identifier identy=new Identifier();
 	String asd=request.getParameter("empid");
 	String id;
 	boolean popup=false;
 	if(asd==null)
 		id=session.getAttribute("emp_id").toString();
 	else
 		{
 		id=request.getParameter("empid"); 
 		popup=true;%>
 		<script type="text/javascript">
 		  
 		
 		</script>
 	<% 	}
 		%>
 		
 		
 		
            <div class="row">
             <div class="col-lg-3" id="info"  style="float: left;">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-info  fa-fw"></i> My Info
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" id="employeeDetails">
                            <% EmployeeInfo einfo=new EmployeeInfo(); %>
                            <% out.print(einfo.myInfo(id)); %>
                       
                          	
                                   <!-- list tasks -->
                            
                            <!-- /.list-group -->
                       </div>
                        <!-- /.panel-body -->
                    </div>
 <div id="rowy"></div>
                    <!-- /.panel .chat-panel --
                </div>

                                <!-- pie  --
                
                <div class="col-sm-6" style="float: left;">

                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> My Status Summary
                                   <div id="show">
            </div>
 </div>
 
 
                        <div class="panel-body" id="donut" >
                        <script type="text/javascript">
                        $(function() {
                        	var taskCompleted= '<%=pMorris.morrisDataTaskCompleted(id,"emp_id") %>';
                        	var taskProgress='<%=pMorris.morrisDataTaskPending(id,"emp_id") %>';
                        	var taskReassigned='<%=pMorris.morrisDataTaskReassigned(id,"emp_id") %>';
                        	var taskFailed='<%=pMorris.morrisDataTaskFailed(id,"emp_id") %>';
                    	Morris.Donut({
                            element: 'morris-donut-chart-emp',
                            data: [{
                                label: "Tasks Completed",
                                value: taskCompleted
                            }, {
                                label: "Tasks in Progress",
                                value: taskProgress
                            }, {
                                label: "Tasks Reassigned",
                                value: taskReassigned
                            }, {
                                label: "Tasks Failed",
                                value: taskFailed
                            }],
                            resize: true
                        });
					});
                        
                        </script>
                        
                            <div id="morris-donut-chart-emp"></div>
						                         
                        </div>
                        <!-- /.panel-body -->
                    </div>

                        

                </div>
                <!-- /.pie  -->
               <div id="rowy1"></div>
                <!-- Employee task table -->
                
                                <div class="col-lg-9" id="mytask" style="float: right; " >
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
                                            <th>Update Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <% 
                                    String prnt=einfo.task(id);
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
                
                <% if(popup)
                {
                	%>
                	<script type="text/javascript">
         			var div=document.getElementById("mytask").hidden = "hidden";
         			document.getElementById("info").className = "col-lg-12 col-sm-12";  
         		//	var div=document.getElementById("rowy").innerHTML="fucker</div>";
         		//var div=document.getElementById("rowy1").innerHTML="fucker</div> <div class=\"col-sm-6\" style=\"float: left;">";
         			//
         			
         			//
         		</script>
               <% }
                	%>
                
                
                <!--  /.Employee task table -->
              <!--   </div>
                <div class="row"> -->
                        
                
                <!-- /.col-lg-8 -->
               
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->



    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../bower_components/raphael/raphael-min.js"></script>
    <script src="../bower_components/morrisjs/morris.min.js"></script>
    <script src="../js/morris-data.js"></script>
   

    <!-- DataTables JavaScript -->
    <script src="../bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="../bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
    

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/populate.js"></script>
    
    <!--  Script for updating task  -->
    <% String strata =request.getParameter("strata");
    String ids=request.getParameter("id"); 
    	String taskid=request.getParameter("taskid");
    		System.out.println(taskid+"fucker");
    		System.out.println(strata);
    %>
	<script type="text/javascript">
	function complete(taskid,id,strata){
		alert (taskid);
		alert (strata);
		window.location = "Empdashboard.jsp?taskid="+taskid+"&amp;id="+id+"&amp;strata="+strata;

		<%
		System.out.print("dsdsad");
		
		if(strata!=null){
		if(request.getParameter("strata").equals("0")){
		String task=request.getParameter("taskid");
		String eid=request.getParameter("id");
		einfo.complete(task, eid); 
		}
		}
		%>
		window.location = "Empdashboard.jsp";
		

	}
	function elevate(taskid,id,stat){
		alert ('E');
		window.location = "Empdashboard.jsp?taskid="+taskid+"&amp;id="+id+"&amp;strata="+strata;
		<% 
		if(strata!=null){
		if(strata.equals("1")){
		String tasks="<script>document.writeln(taskid);</script>";
		String eids="<script>document.writeln(id);</script>";
		einfo.elevate(tasks, eids); 
		}
		}
		%>
		window.location = "Empdashboard.jsp"; 
	}
	</script>



</body>

</html>

