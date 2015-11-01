  <!DOCTYPE html>
  <%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vz.hackathon.helper.SQLHelper"%>
  <%@page import="vz.hackathon.logic.TeamView"%>
  <%@page import="java.sql.*"%>
<html lang="en">
  
  <head>
  
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
  
      <title>Zepthy</title>
  
  	<script>
  	
  	<% 
  	String emp_id=(session.getAttribute("emp_id").toString());
  	
  	Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
    System.out.println("Connection Successful!");
    Statement stmt = conn.createStatement();
    Statement stmt2 = conn.createStatement();
    Statement stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    ResultSet rs=stmt.executeQuery("select name,emp_id from employee where manager_id = " + emp_id);
    
   
    
    ArrayList<String> emps=new ArrayList<String>();
    ArrayList<String> empids=new ArrayList<String>();
    ArrayList<Integer> tasks=new ArrayList<Integer>();
    String emp_name="";
    while(rs.next())
    {	
    	
    	emp_name=rs.getString("name");
    	emps.add(emp_name);
    	empids.add(rs.getString("emp_id"));
    	ResultSet rstask=stmt3.executeQuery("select count(task_id) as cnt from bucket where emp_id = '" + rs.getString("emp_id")+"'");
    	if(rstask.first())
    		tasks.add(rstask.getInt("cnt"));
    }
  	
    ResultSet rs2=stmt2.executeQuery("select name from employee where emp_id = " + emp_id);
    String manager_name="";
    while(rs2.next())
    manager_name=rs2.getString("name");
  	
  	String divContent="  <li style=\"list-style: none;\">"+
            "<div class=\"panel panel-default\">"+
        "<div class=\"panel-heading\">"+
             "<i class=\"fa-fw\"></i>"+ manager_name
         +"</div>"+
       "</div><ul>";
       String divc="";
   	  for(int i=0; i<emps.size(); i++){
   	  divc+=
       	    	"<li style=\"list-style: none;\">"
       +" <div class=\"panel panel-default\">"
        +" <div class=\"panel-heading\">"
       +  "     <i class=\"fa-fw\"></i>"
       +"<table><tr><td width=\"300px\">"
        + "<a href=\"http://localhost:8080/hackathon/pages/Empdashboard.jsp?pw=800&amp;ph=600&amp;empid="+empids.get(i)+"\" class=\"default_popup\"> " +emps.get(i) 
        +"</td><td width=\"300px\"><a href=\"http://localhost:8080/hackathon/pages/taskdetails.jsp?pw=800&amp;ph=600&amp;taskid="+tasks.get(i)+"&amp;empid="+empids.get(i)+"\" class=\"default_popup\"> Tasks Alloted: " +tasks.get(i) 
        + " </td></tr></table></div>"
       + "</div>"
         +"  </li>";
   	  }
  	  divContent+=divc+ " </ul>   </li> ";
       System.out.println(divContent);
  	%>
  	function teamView(){
  		//alert('here');
  	  var divTag = document.getElementById('team');

  	divTag.innerHTML=<%= divContent %>;
  	</script>
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
      <![endif]-->
  
  </head>
  
  <body >
  
      <div id="wrapper">
  
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
             <!--             <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                          </li>
                 -->         <li class="divider"></li>
                          <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                          </li>
                      </ul>
                      <!-- /.dropdown-user -->
                  </li>
                  <!-- /.dropdown -->
              </ul>
              <!-- /.navbar-top-links -->
  
              <div class="navbar-default sidebar" role="navigation">
                  <div class="sidebar-nav navbar-collapse">
                      <ul class="nav" id="side-menu">
                         <!-- <li class="sidebar-search">
                              <div class="input-group custom-search-form">
                                  <input type="text" class="form-control" placeholder="Search...">
                                  <span class="input-group-btn">
                                  <button class="btn btn-default" type="button">
                                      <i class="fa fa-search"></i>
                                  </button>
                              </span>
                              </div>
                              <!-- /input-group --
                          </li> -->
                          <li>
                              <a href="dashboard.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                          </li>
                          <li>
                              <a href="team.jsp"><i class="fa fa-dashboard fa-fw"></i> Team View</a>
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
                          <h1 class="page-header">Team View</h1>
                      </div>
                      <!-- /.col-lg-12 -->
                  </div>
                  <!-- /.row -->
               <div class="row">
                  <div class="col-lg-12" id="team">
  						<% 
  						
  						out.print(divContent);
  						
  						%>
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
  
     <!-- Custom Theme JavaScript -->
    <script src="../js/populate.js"></script>
    
    <!-- popup scripts -->
 	<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>-->
	<script src="../js/jquery.popup.js"></script>
	<script>
		$(function(){

			/*-------------------------------

				GENERAL EXAMPLES

			-------------------------------*/

			// Default usage
			$('.default_popup').popup();



		});

		/*---------------------

			JQUERY EASING

		*/

		$.extend($.easing, {
			easeOutBack: function (x, t, b, c, d, s) {
				if (s == undefined) s = 1.70158;
				return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
			},
			easeInBack: function (x, t, b, c, d, s) {
				if (s == undefined) s = 1.70158;
				return c*(t/=d)*t*((s+1)*t - s) + b;
			}
		});



	</script>
  
  </body>
  
  </html>
