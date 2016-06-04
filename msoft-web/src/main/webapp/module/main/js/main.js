Ext.ns("MS.main");

Ext.Loader.setConfig({enabled: true});
Ext.Loader.setPath('Ext.ux','/res/ux');
Ext.require([
    'Ext.util.*',
    'Ext.tip.QuickTipManager',
    'Ext.panel.*',
    'Ext.window.Window',
    'Ext.tab.Panel',
    'Ext.ux.TabScrollerMenu',
    'Ext.tab.*'
]);

var g_oViewPort = null;

Ext.onReady(function() {
	Ext.QuickTips.init();
	g_oViewPort = new Ext.container.Viewport({
		layout:'border',
		items:[topPanel,leftPanel,centerTab]
	});
});