Ext.ns("MS.demo");

Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux','/res/ux');
Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
    'Ext.toolbar.Paging',
    'Ext.ux.PreviewPlugin',
    'Ext.ModelManager',
    'Ext.form.Panel',
    'Ext.ux.form.MultiSelect',
    'Ext.ux.form.ItemSelector',
    'Ext.tip.QuickTipManager'
]);

var g_oViewPort = null;
Ext.onReady(function() {
	Ext.QuickTips.init();
	/*
	Ext.create('Ext.container.Viewport', {

	    layout: 'border',
	    items: [{
	        xtype: 'demogrid'
	    }]
	});*/
	g_oViewPort = new Ext.container.Viewport({
		layout:'border',
		items:[{
			xtype:'demogrid'
		}]
	});
	
});