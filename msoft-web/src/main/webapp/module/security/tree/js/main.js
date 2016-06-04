Ext.ns("MS.security.tree");

Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux','/res/ux');
Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
    'Ext.toolbar.Paging',
    'Ext.ux.PreviewPlugin',
    'Ext.ModelManager',
    'Ext.tip.QuickTipManager'
]);

var g_oViewPort = null;
var treePanel=null;
Ext.onReady(function() {
	Ext.QuickTips.init();
	treePanel = Ext.create('MS.security.tree.TreePanel');
	treePanel.expandAll();
	g_oViewPort = new Ext.container.Viewport({
		layout:'border',
		items:[treePanel]
	});
});