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
    'Ext.tip.QuickTipManager',
    'Ext.ux.ajax.JsonSimlet',
    'Ext.ux.ajax.SimManager'
]);

function createDockedItems(fieldId) {
    return [{
        xtype: 'toolbar',
        dock: 'top',
        items: {
            text: 'Options',
            menu: [{
                text: 'Get value',
                handler: function(){
                    var value = Ext.getCmp(fieldId).getValue();
                    Ext.Msg.alert('Value is a split array', value.join(', '));
                } 
            }, {
                text: 'Set value (2,3)',
                handler: function(){
                    Ext.getCmp(fieldId).setValue(['2', '3']);
                }
            },{
                text: 'Toggle enabled',
                checked: true,
                checkHandler: function(item, checked){
                    Ext.getCmp(fieldId).setDisabled(!checked);
                }
            },{
                text: 'Toggle delimiter',
                checked: true,
                checkHandler: function(item, checked) {
                    var field = Ext.getCmp(fieldId);
                    if (checked) {
                        field.delimiter = ',';
                        Ext.Msg.alert('Delimiter Changed', 'The delimiter is now set to <b>","</b>. Click Save to ' +
                                      'see that values are now submitted as a single parameter separated by the delimiter.');
                    } else {
                        field.delimiter = null;
                        Ext.Msg.alert('Delimiter Changed', 'The delimiter is now set to <b>null</b>. Click Save to ' +
                                      'see that values are now submitted as separate parameters.');
                    }
                }
            }]
        }
    }, {
        xtype: 'toolbar',
        dock: 'bottom',
        ui: 'footer',
        defaults: {
            minWidth: 75
        },
        items: ['->', {
            text: 'Clear',
            handler: function(){
                var field = Ext.getCmp(fieldId);
                if (!field.disabled) {
                    field.clearValue();
                }
            }
        }, {
            text: 'Reset',
            handler: function() {
                Ext.getCmp(fieldId).up('form').getForm().reset();
            }
        }, {
            text: 'Save',
            handler: function(){
                var form = Ext.getCmp(fieldId).up('form').getForm();
                form.getValues(true);
                if (form.isValid()){
                    Ext.Msg.alert('Submitted Values', 'The following will be sent to the server: <br />'+
                        form.getValues(true));
                }
            }
        }]
    }];
}

var ds = Ext.create('Ext.data.ArrayStore', {
    data: [[123,'One Hundred Twenty Three'],
        ['1', 'One'], ['2', 'Two'], ['3', 'Three'], ['4', 'Four'], ['5', 'Five'],
        ['6', 'Six'], ['7', 'Seven'], ['8', 'Eight'], ['9', 'Nine']],
    fields: ['value','text'],
    sortInfo: {
        field: 'value',
        direction: 'ASC'
    }
});

Ext.define('MS.demo.window.MultiSelect', {
    extend: 'Ext.window.Window',
    requires: ['Ext.form.Panel'],
    title : 'Edit demo',
    layout: 'fit',
    autoShow: true,
    height: 400,
    width: 700,
    items:[{
    	xtype:'form',
        width: 700,
        
        height: 300,
        layout: 'fit',
        items:[{
            xtype: 'itemselector',
            name: 'itemselector',
            id: 'itemselector-field',
            anchor: '100%',
            fieldLabel: 'ItemSelector',
            imagePath: '/res/ux/images/',
            store: ds,
            displayField: 'text',
            valueField: 'value',
            value: ['3', '4', '6'],
            allowBlank: false,
            msgTarget: 'side',
            fromTitle: 'Available',
            toTitle: 'Selected'
        }],
        dockedItems: createDockedItems('itemselector-field')
    }],
    
    initComponent: function() {
    	
    	this.callParent();
    	
    }
});

