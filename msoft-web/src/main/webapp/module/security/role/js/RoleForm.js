Ext.ns("MS.security.role");


Ext.define('MS.security.role.AddRolePanel', {
    extend: 'Ext.Panel',
    requires: ['Ext.form.Panel'],
    title:'增加角色',
    id:'security_role_addRolePanel_id',
    layout:'fit',
    rightValue:{},
    fieldDefaults: {
        labelAlign: 'right',
        labelWidth: 90,
        anchor: '100%'
    },
    constructor: function (config) {
        this.initConfig(config); 
        this.callParent([config]); 
    },
    initComponent: function() {
    	var me = this;
    	var powerTreePanel = new Ext.create('MS.security.role.RolePowerTree');
    	powerTreePanel.expandAll();
    	this.items =[{ 
    		xtype: 'form',
    		bodyStyle: 'background:#fcfcfc; padding:0px;',
            border: false,
            items:[{
    			xtype:'panel',
    			bodyStyle: 'background:#dfe8f6; padding:0px;',
    			items:[{
    				xtype: 'textfield',
        			name : 'name',
        			padding:'8px 0 5px 10px',
        			fieldLabel: '角色名称',
        			align:'center'
    			}]
    		},powerTreePanel]
    	}];
    	this.buttons = [{
            text: '保存',
            scope:this,
            handler:function(btn,e){
            	//alert('title');
            	//var window = btn.up('panel');
				//var form = window.down('form').getForm();
				//var oValue = Ext.getCmp('security_role_RolePowerTree_id').getValue();
				
				//alert(oValue.aNode.length);
            	var selectedNode = [];
            	var nodes = powerTreePanel.getRootNode().childNodes;
            	
            	//getAllChildrenNodes(powerTreePanel.getRootNode(),selectedNode);
            	
            	
            	for(var i = 0;i< nodes.length; i++){
            		var node = powerTreePanel.getRootNode().childNodes[i];
            		if(node.checked){
            			alert(node.checked);
            			//selectedNode.push(node.data.id);
            			//alert(node.hasParentNode());
            			//alert(node.parentNode.data.id);
            			//getParentNodes(node,selectedNode);
            			//findChildrenNodes(node,selectedNode);
            		}
            		
            		
            	}
            	alert(powerTreePanel.getChecked());
            	
            	
            	//alert(powerTreePanel.id);
            	
            	
				//alert(oValue.length);
				//if(form.isValid()){
					//var vals = form.getValues();
					//alert(vals['name']);
					
				//}
            	
            	//alert(me.rightValue);
            	//me.rightValue = setChildrenRightValue(me);
            	//alert( Ext.encode(me.rightValue));
            	
            }
        },
        {
            text: 'Cancel',
            scope: this,
            //handler: this.close
            handler:function(){
            	this.hide();
            	//this.close();
            	roleRightPanel.remove(roleRightPanel.items.get(0));
            	roleRightPanel.collapse();
            	//blankPanel.items.get(0).remove();
            	//blankPanel = Ext.create('MS.security.role.Blank');
            	//g_oViewPort.doLayout();
            	//blankPanel.doLayout();
            }
        }];
    	
    	
    	
    	Ext.apply(this,{
    	});
    	this.callParent();
    	
    }
});


function getParentNodes(node,selectedNodeIds){
	if(node.parentNode){
		
		var parentNode = node.parentNode;
		selectedNodeIds.push(parentNode.data.id);
		getParentNodes(parentNode,selectedNodeIds);
	}
	
}

function getAllChildrenNodes(node,selectedNodeIds){
	
}

function findChildrenNodes(node,selectNodeIds){
	var childrens = node.childNodes;
	for(var i=0;i<childrens.length;i++){
		var nd = node.childNodes[i];
		//nd = childrens[i];
		//alert(nd.data.id);
		//alert(nd.checked);
		if(nd.checked){
			selectNodeIds.push(nd.data.id);
		}else{
			alert('false');
		}
		alert(Ext.encode(nd.checked));
		
		
		//if(nd.hasChildNodes()){
			//findChildrenNodes(nd,selectNodeIds);
		//}
	}
}