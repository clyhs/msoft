Ext.ns("MS.main");

Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux','/res/ux');

var centerTab = Ext.create('Ext.TabPanel',{
	region: 'center', 
	deferredRender: false,  
	margins: '0 5 0 0',  
	activeTab: 0, 
	plugins : Ext.create('Ext.ux.TabCloseMenu', {
		closeTabText : '关闭面板',
		closeOthersTabsText : '关闭其他',
		closeAllTabsText : '关闭所有'
	}),
	items:[{
		title: 'home',  
		autoScroll: true,
        region : 'center',
        layout:'fit',
		items:[{
			style : 'padding:0 0 10px 0',
            items : [{
                title : '首页',
                autoScroll:false,
                autoWidth:true,
                height:470,
                scripts:true,
                html: '<div style="margin:20% 40%;font-size:24px;font-family:Arial, Helvetica, sans-serif;">hello world</div>'
            }]
			
		}]
	}]
	
});