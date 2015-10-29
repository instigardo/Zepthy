	// JavaScript Document
	var mapDataCountry=[ ];
	var mapDataState=[ ];
	var regArray=[ ];
 	var stateArray=[ ];
	var BillId= [ ];
	var BillAmt=[ ];
		
	function populator(codeo)
	{
		alert('here fucker');
		var state=codeo;
		var user=getUserDetails();
		var region_code=stateArray[state];
		var accordianStr='';
		var tableStr='';

		if(user=='john' && (region_code=='US-AL' || region_code=='US-MT' || region_code=='IN-HP' || region_code=='IN-DL' || region_code=='IN-TN'))
		{
			var i=0;
			 BillId= [ 101,102,103,104,105 ];
			 BillAmt=[ 425,325,547,789,475 ];
			var BillDueDate=['27-Sep-2015','28-Sep-2015','30-Sep-2015','29-Sep-2015','26-Sep-2015' ];
			
			
			var bill_show_div=document.getElementById('bill_show');
			
			for(i=0; i< BillId.length; i++)
			{
				accordianStr+='<h3 id="billId" style="color:#010101">   | #'+ BillId[i] +'</h3><div><table align="left" style="margin-left:20px; width:50%; float:left"><tr> <td style="text-align:left">Bill Id</td> <td style="text-align:left">:'+BillId[i]+'</td></tr><tr> <td style="text-align:left">Bill Amount</td> <td style="text-align:left">:'+BillAmt[i]+'</td></tr><tr> <td style="text-align:left">Bill Due Date</td> <td style="text-align:left">:'+BillDueDate[i]+'</td></tr></table><div class="bill_buttons" style="height:50px; width:50%; margin-left:50%;"><input type="button" onClick="uniBilling('+BillId[i]+')"  value="Add To UniBilling"><br><br><input type="button" onClick="uniException('+BillId[i]+')" value="Add To UniException"></div><div class="line" style="border-top:2px solid; width:100%; margin-top:2%"> <div class="jsonBill"></div> </div></div>';
			
			}
			bill_show_div.innerHTML='<div id="accordion" style="text-align:left;">'+ accordianStr +'</div>';

		}
		else if (user =='linda')
		{
			var bill_show_div=document.getElementById('bill_show');
			
			bill_show_div.innerHTML+='<table><tr><td><input type="checkbox" name="'+ region_code +'"> </td><td></td></tr></table>';
			alert('feefe');

		}
		call_jquery_for_accordion();
	}
	
	
	function userDataPopulate()
	{
		var user=getUserDetails();
		if(user=='john')
		{
			mapDataCountry=[['Country', 'Popularity'],['',''],['United States', 'United States: 300'],['India', 'India: 500']];
			regArray=['','US','IN' ];
 			mapDataState=[['State', 'Popularity'],['',''],['US-AL', '300'],['US-MT', '300'],['IN-HP', 'Himachal Pradesh: 300'],['IN-DL', 'Delhi: 300'],['IN-TN', 'Tamil Nadu : 300']];
			stateArray=[ '','US-AL', 'US-MT', 'IN-HP', 'IN-DL', 'IN-TN' ];
		}
		else if(user=='linda')
		{
			mapDataCountry=[['Country', 'Popularity'],['',''],['United States', 'United States: 300']];
			regArray=['','US' ];
			mapDataState=[['State', 'Popularity'],['',''],['US-AL', '300'],['US-MT', '300']];
			stateArray=[ '','US-AL', 'US-MT'];
		}
		drawRegionsMap();
	}
	function getMapDataCountry(){
			if(mapDataCountry!='')
			return mapDataCountry;
	}
	function getMapDataState(){
			if(mapDataState!='')
			return mapDataState;
	}
	function getRegArray(){
			if(regArray!='')
			return regArray;
	}
		function getStateArray(){
			if(stateArray!='')
			return stateArray;
	}
		function getBillId(){
			if(BillId!='')
			return BillId;
	}
	function getBillAmt(){
			if(BillAmt!='')
			return BillAmt;
	}