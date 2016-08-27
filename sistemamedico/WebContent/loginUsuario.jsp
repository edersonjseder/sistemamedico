<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich"    prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j"     prefix="a4j"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" http://www.w3.org/TR/html4/loose.dtd> 
<html> 
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Sistema Médico - Usuario</title> 
</head> 

<body> 
	<f:view>
	<h:form>
		<div id="logo" class="logo">Sistema Médico</div>
	    <div id="header" class="header">
	    	<div id="left_header" class="left_header"></div>
	        <div id="right_header" class="right_header"></div>
  		</div> 
  		
		<!-- main -->
	    <div id="content" class="content">
	    	<div id="content_top" class="content_top">
	        	<div id="content_top_left" class="content_top_left"></div>
	            <div id="content_top_right" class="content_top_right"></div>
	        </div>
			<div id="content_body" class="content_body">
			 	<div id="sidebar" class="sidebar">
	            	<div id="sidebar_top" class="sidebar_top"></div>
					<div id="sidebar_body" class="sidebar_body"><p><span>Usu&aacute;rio</span></p></div>
	                <div id="sidebar_bottom" class="sidebar_bottom"></div>
	          	</div>
	            <div id="text" class="text">
		            <div id="text_top" class="text_top">
		            	<div id="text_top_left" class="text_top_left"></div>
		                <div id="text_top_right" class="text_top_right"></div>
		            </div>
	
					<div id="text_body_inicio_user" class="text_body_inicio_user">
						<h:panelGrid columns="3">
							<h:panelGroup>
								<h:outputText value="Login:"/>
								<h:inputText id="login" size="20" maxlength="30" />
							</h:panelGroup>
							
							<h:panelGroup>
								<h:outputText value="Senha:"/>
								<h:inputSecret id="senha" size="20" maxlength="50" />
							</h:panelGroup>
							
							<h:commandLink styleClass="botao" value="Entrar"/>
						</h:panelGrid>
					</div>
					<div id="text_bottom" class="text_bottom">
	                	<div id="text_bottom_left" class="text_bottom_left"></div>
	                    <div id="text_bottom_right" class="text_bottom_right"></div>
	                </div>				
				</div>
			</div>
			<div id="content_bottom" class="content_bottom">
	        	<div id="content_bottom_left" class="content_bottom_left"></div>
	            <div id="content_bottom_right" class="content_bottom_right"></div>
	        </div>
		</div>
		<!-- end main -->
	
	    <!-- footer -->
	    <div id="footer" class="footer">
		    <div id="left_footer" class="left_footer"></div>
		    <div id="right_footer" class="right_footer"></div>
	    </div>
	    <!-- end footer -->
	</h:form>
    </f:view>
</body> 
</html>