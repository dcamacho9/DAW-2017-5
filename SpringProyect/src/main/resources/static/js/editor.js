$(document).ready(function(){
	var contVinilos = 0;
	var contOfertas= 0;
	var contOfertasDescuento =0;
	
	$("#moreVinilos").on("click",function(){
		
		contVinilos++;
		$.get("/moreVinilos",{
			page:contVinilos
			
		})
		.done(function(data){
			if(!$.trim(data)){
				$("#moreVinilos").attr("disabled","disabled");
			}else{
				$("#vinilos .listItems").append(data);
			}
			});
			
		});
		
	$(document).ready(function(){
		var contOfertas = 0;
		
		$("#moreOfertas").on("click",function(){
			
			contOfertas++;
			$.get("/moreOfertas",{
				page:contVinilos
				
			})
			.done(function(data){
				if(!$.trim(data)){
					$("#moreOfertas").attr("disabled","disabled");
				}else{
					$("#ofertas .listItems2").append(data);
				}
				});
				
			});
		$(document).ready(function(){
			var contOfertasDescuento = 0;
			
			$("#moreOfertasDescuento").on("click",function(){
				
				contOfertas++;
				$.get("/moreOfertasDescuento",{
					page:contVinilos
					
				})
				.done(function(data){
					if(!$.trim(data)){
						$("#moreOfertasDescuento").attr("disabled","disabled");
					}else{
						$("#ofertasDescuento .listItems3").append(data);
					}
					});
					
				});
		
		});
});
});