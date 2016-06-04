Ext.ns("MS.main");

Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux','/res/ux');


var leftPanelStore = Ext.create('Ext.data.TreeStore', {
    proxy: {
        type: 'ajax',
        url: '/module/security/getAllTree.json'
    },
    sorters: [{
        property: 'leaf',
        direction: 'ASC'
    }, {
        property: 'text',
        direction: 'ASC'
    }]
});

var leftPanel = Ext.create('Ext.tree.Panel', {
	region:'west',
	id:'west',
    store: leftPanelStore,
    rootVisible: false,
    useArrows: true,
    frame: false,
    title: '导航菜单',
    split : true,
    collapsible : true,
	animCollapse : true,
    width: 200,
    tbar:[{
    	text:'展开所有',
    	handler:function(){
    		this.leftPanel.expandAll();
    	},
    	scope:this
    },{
    	text:'缩起全部',
    	handler:function(){
    		this.leftPanel.collapseAll();
    	},
    	scope:this
    },'->',{
    	text:'刷新',
    	handler:function(){
    		this.leftPanel.getStore().reload();
    	},
    	scope:this
    }],
    listeners : {
		'itemclick' : function(e, record) {
			//alert(e);
			//alert(record.data.id);
			//alert(record.data.text);
			//alert(record.raw.url);
			if(record.data.leaf){
				openTab(record.data.id,record.data.text,record.raw.url,{});
			}
			
		}
	}
});

function openTab(tabId,tabTitle,tab,config){
	var _tab = centerTab.getComponent('tab' + tabId);
	if(!_tab){
		_tab = Ext.create('Ext.panel.Panel', {
			closable : true,
			id : 'tab' + tabId,
			title : tabTitle,
			layout : 'fit',
			autoScroll : true,
			border : false,
			scripts:true,
            html: '<iframe src= "'+tab+'" width="100%" height="100%" marginwidth="0" framespacing="0" marginheight="0" frameborder="0" ></iframe>'
		});
		centerTab.add(_tab);
	}else{
	}
	centerTab.setActiveTab(_tab);
}