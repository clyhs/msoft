Ext.Loader.setConfig({
	enabled : true
});


Ext.application({
    name: 'MS',
    
    appFolder:'../user',

    paths: {
        'Ext.ux': '/res/ux'
    },

    controllers: [
        'Users'
    ],


    
    autoCreateViewport: true
});