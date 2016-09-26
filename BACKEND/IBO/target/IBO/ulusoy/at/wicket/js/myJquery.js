

$(document).ready(function()
		{
			$(function() {
					 $("#bestelleArtikelName").autocomplete({
						 source: availableProdukte,
						 minLength:3
					 });
			});
});
$(function(){
	$('#slides').slides({
		preload: true,
		generatePagination: false,
		generateNextPrev: false
	});
});

function showfilter(){
		var myobject=document.getElementById("filterswitch");
		var mystatus=myobject.className;
		var myshow=document.getElementById("filter_content");
		$(myshow).slideToggle('slow', function()  {
		if(mystatus == "minus"){
				myobject.className="plus";
			}else{
			myobject.className="minus";
			}
});
}