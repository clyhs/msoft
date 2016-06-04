Ext.ns("MS.main");


var topPanel = Ext.create('Ext.Panel',{
	region:"north",
	id:"topPanel",
	contentEl:"north",
    height:60
	
});

function selectSwitch(current){
    var lis=document.getElementsByTagName("li")
    for(var i=0;i<lis.length;i++){
        if(lis[i].className=="activeli"){
            lis[i].className="commonli";
        }
    };
    current.className="activeli";
}
