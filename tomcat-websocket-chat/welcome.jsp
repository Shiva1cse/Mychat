<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import ="java.sql.*" %>
<%@ page import ="java.sql.*" %>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
var StoreName='';
var count=0;
$(document).ready(function() {
     $('#ibutton').click(function(e) {
     e.preventDefault();
     var ajaxdata = $("#ChatterName").val();
     var value ='ChatterName='+ajaxdata;
     $.ajax({
     type:'POST',
     url: "ChatServlet",
     data: value,
     cache: false,
     success: function(data) {
    	 StoreName=ajaxdata;
    	document.getElementById("myname").innerHTML ="Welcome "+ajaxdata;
    	call();
	
     }
     });
   
});

});

setInterval(function(){
	
	  $.ajax({
	         type:'GET',
	         url: "ChatServlet",
		         cache: false,
	         success: function(data) {
	        	 console.log(data+"ff")
	        	 $("#test").load("welcome.jsp #test");
             //$('#test').html(data);

	        	}
	  //document.getElementById("msgList").innerHTML=("");

	         });
}, 2000);

    var a=new Array();
    function sendMessage()
    {
    	var msg=document.getElementById("msg").value;
    	console.log(msg+"msg");
    	var value='Message='+msg+'&name='+StoreName;
    	$.ajax({
    		url:"SendMessage",
    		data:value,
    		Chache:false,
    		success:function(data)
    		{
    		}
    	});
    	
     	var myMessage;
    	for(var i=0;i<a.length;i++){
    		myMessage+=a[i]+"\n";
    	}
    	var msg=document.getElementById("msg").value;
    	//document.getElementById("msgList").innerHTML =myMessage;	
    	document.getElementById("msg").value='';
    	a.length=0;
    	a.push(myMessage);
    }
</script>
</head>	
<body>

        	 
        	
<center>
     <font face="verdana" size="2">Name:</font>
     <input type="text" name="ChatterName" id=ChatterName size="30" />
     <input type="button" id="ibutton" value="Save"/>
	 <h1 align="center" id="myname" name="myname">UserName</h1>
     <div align="center">
     <div id="test">
        <textarea readonly  rows="30" id="msgList" cols="100">
        <%=(String)session.getAttribute("uname")%>
     </textarea>
    </div>
       <br>
       <input type="text" id="msg" name="messege" size="50">
       <input type="button" value="Send " onclick="sendMessage()" />
	 </div>
</center>
</body>
</html>