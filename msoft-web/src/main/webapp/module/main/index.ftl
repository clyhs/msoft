<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>msoft</title>

    <link type="text/css" rel="stylesheet" href="${request.getContextPath()}/res/css/ext-all.css" />
    <link type="text/css" rel="stylesheet" href="${request.getContextPath()}/res/css/main.css" />
    <script type="text/javascript" src="${request.getContextPath()}/res/js/ext-all-debug.js"></script>
    
    <script type="text/javascript" src="${request.getContextPath()}/module/main/js/top.js"></script>
    <script type="text/javascript" src="${request.getContextPath()}/module/main/js/center.js"></script>
    <script type="text/javascript" src="${request.getContextPath()}/module/main/js/left.js"></script>
    <script type="text/javascript" src="${request.getContextPath()}/module/main/js/main.js"></script>
    
</head>
<body>
    <div id="loading-mask"></div>
	<div id="loading">
		<div class="loading-indicator"></div>
	</div>
	<div id="north">
		<div id="app-header">
			<div id="header-left">
				<!--<img id="logo" height="50" style="max-width:220px;" src=""/>-->
				<div style="width:300px;height:50px;"></div>
			</div>
			<div id="header-main">
				<div id="topInfoPanel" style="float: left; padding-bottom: 4px;border:#ccc 0px solid;">
					<div id="welcomeMsg" style="width:500px;">欢迎 admin</div>

				</div>
				<div class="clear"></div>
				<ul id="header-topnav" style="border:#ccc 0px solid;">
				    <li class="commonli"   onmouseover="selectSwitch(this); "><a href="#" onclick="show('security');" class="menu-desktop">安全管理</a></li>
                    <li class="commonli"   onmouseover="selectSwitch(this); "><a href="#" onclick="show('system');" class="menu-desktop">系统管理</a></li>
                    <li class="commonli"   onmouseover="selectSwitch(this); "><a href="#" onclick="show('monitor');" class="menu-desktop">系统监控</a></li>
				</div>
				
			</div>
			<div id="header-right">
				<div id="currentTime">
					<span id="time"></span>
				</div>
				<div id="setting">
					
				</div>
				
				<div id="search" style="width: 260px; float: right; padding-top: 8px;">&nbsp;</div>
			</div>
		</div>
	</div>

	<div id="west"></div>
	<div id="south"></div>
	<div id="main"></div>
</body>
</html>