Ext.ns("MS.security.role");

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
var roleTreePanel=null;
var roleRightPanel = null;
Ext.onReady(function() {
	Ext.QuickTips.init();
	roleTreePanel = Ext.create('MS.security.role.RoleTreePanel');
	
	roleTreePanel.expandAll();
	
	roleRightPanel = Ext.create('MS.security.role.RoleRightPanel');
	g_oViewPort = new Ext.container.Viewport({
		layout:'border',
		items:[roleTreePanel,roleRightPanel]
	});
});