var system = {
		orgName : "system.orgName",
		
		test : function(){
			return "system.test()";
		},
		
		_getLogo : function(logo){
			if(logo == ''){
				logo = 0;
			}
			return logo;
		}
}
