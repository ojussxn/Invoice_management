var btn1 = document.getElementById('add');
var modal1 = document.getElementsByClassName('addmodal');
var close1 = document.getElementById('c1');
var cancel1 = document.getElementById('cancel1');



btn1.addEventListener('click',function(){
	document.getElementById('xte').style.display='flex';
});


close1.addEventListener('click',function(){
	document.getElementById('xte').style.display='none';
});


cancel1.addEventListener('click',function(){
	document.getElementById('xte').style.display='none';
});


var btn2 = document.getElementById('edit');
var modal2 = document.getElementsByClassName('editmodal');
var close2 = document.getElementById('c2');

btn2.addEventListener('click',function(){
	document.getElementById('xyz').style.display='block';
});

close2.addEventListener('click',function(){
	document.getElementById('xyz').style.display='none';
});



var btn3 = document.getElementById('delete');
var modal3 = document.getElementsByClassName('delmodal');
var close3 = document.getElementById('c3');
var cancel1 = document.getElementById('cancel2');

btn3.addEventListener('click',function(){
	document.getElementById('abc').style.display='block';
});

close3.addEventListener('click',function(){
	document.getElementById('abc').style.display='none';
});
cancel2.addEventListener('click',function(){
	document.getElementById('abc').style.display='none';
});



function buildTable(data){
	var table = document.getElementById('myTable')

	for (var i = 0; i < 12; i++){
		var row = `<tr>
						<td><input type="checkbox"></input></td>
						<td>${data[i].name}</td>
						<td>${data[i].numb}</td>
						<td>${data[i].id}</td>
						<td>${data[i].amt}</td>
						<td>${data[i].date}</td>
						<td>${data[i].pdate}</td>
						<td>${data[i].notes}</td>
				  </tr>`
		table.innerHTML += row


	}
}
var result;
function returnJSONData()
{
	var processData = 'JSON'; 
	  $.ajax({  
		type: "GET",  
		url: "http://localhost:8080/H2HBABBA3080/AddServlet",  
		data: "processData="+processData,  
		success: function(result){
			result=JSON.parse(result)
			buildTable(result)
			console.log(result);
		},
		error: function (xhr, ajaxOptions, thrownError) {
			alert("Error status code: "+xhr.status);
			alert("Error details: "+ thrownError);
		}
	  }); 

}

returnJSONData()