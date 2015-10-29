$( document ).ready(function() {

	alert("aaa");
	$.ajax({
	    type: 'get',
	    url: '../HighPriorityJobs',
	    dataType: 'text',
	    data: '',
	    success: function(data) {
	    	alert("ssss");

	    },
	    error: function(data) {
	        alert('fail');
	    }
	});


//	function populate() {
//		//alert ('dcsdc');
//		  var divTag = document.getElementById('priority_tasks');
//
//		  var task[]='task job';
//		  var assignee[]='worker';
//		  var divContent='';
//		  for(i=1; i<5; i++)
//			{
//		divContent+=  '  <div class="list-group" ><i class="fa fa-comment fa-fw"></i>'+ task +
//		  '<span class="pull-right text-muted small"><em>'+ assignee +'</em></span></div> ';
//			}
//		divTag.innerHTML=divContent;
//
//
//
//		}

		function teamView(){
			//alert('here');
			  var divTag = document.getElementById('team');
			var ManagerDetails='manu';
			var EmployeeDetails='dada';
			
			  var divContent=  '  <li style="list-style: none;">'+
		          '<div class="panel panel-default">'+
		      '<div class="panel-heading">'+
		           '<i class="fa-fw"></i>'+ ManagerDetails
		       +'</div>'+
		     '</div><ul>';
			  
		       var divc='';
			  for(i=0; i<5; i++){
			  divc+=
		    	    	'<li style="list-style: none;">'
		    +' <div class="panel panel-default">'
		     +' <div class="panel-heading">'
		    +  '     <i class="fa-fw"></i>'+  EmployeeDetails
		     + ' </div>'
		    + '</div>'
		      +'  </li>';
			  
		}
			  divContent+=divc+ ' </ul>   </li> ';

			divTag.innerHTML=divContent;
		}
});


