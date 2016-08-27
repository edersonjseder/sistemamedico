<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich"    prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j"     prefix="a4j"%>
<f:loadBundle basename="br.com.sistemamedico.bundle.Messages" var="msg"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" http://www.w3.org/TR/html4/loose.dtd> 
<html> 
<head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>Sistema Médico - Alteração Medicamentos</title> 
</head>

<body> 
<f:view>
<h:form>
	<div id="logo" class="logo"><h:outputText value="#{msg.label_titulo}"/></div>
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
				<div id="sidebar_body" class="sidebar_body"><p><span><h:outputText value="#{msg.label_lateral_alteracao_medicamento}" styleClass="estilo_texto_label_lateral"/></span></p></div>
                <div id="sidebar_bottom" class="sidebar_bottom"></div>
          	</div>
            <div id="text" class="text">
	            <div id="text_top" class="text_top">
	            	<div id="text_top_left" class="text_top_left"></div>
	                <div id="text_top_right" class="text_top_right"></div>
	            </div>

				<div id="text_body_cadastro" class="text_body_cadastro">
					<h:panelGrid border="0" columns="3">
						<h:panelGroup>
							<h:outputText value="#{msg.nome_alteracao_medicamento}" styleClass="estilo_texto_label"/>
							<h:inputText id="medicamento" size="30" maxlength="60" value="#{controleMedicamentos.medicamentos.nomeMedicamento}" styleClass="estilo_texto"/>
						</h:panelGroup>
						
						<h:panelGroup>
							<h:outputText value="#{msg.data_validade_alteracao_medicamento}" styleClass="estilo_texto_label"/>
							<rich:calendar id="validade" inputSize="10" value="#{controleMedicamentos.medicamentos.vencimento}" inputClass="estilo_texto" datePattern="dd/MM/yyyy" boundaryDatesMode="scroll"/>
						</h:panelGroup>
						
						<h:panelGroup>
							<h:outputText value="#{msg.descricao_alteracao_medicamento}" styleClass="estilo_texto_label"/>
							<h:inputText id="descricao" size="10" maxlength="50" value="#{controleMedicamentos.medicamentos.descricao}" styleClass="estilo_texto"/>
						</h:panelGroup>
						
						<f:verbatim>&nbsp;</f:verbatim>
						
						<f:verbatim>&nbsp;</f:verbatim>
						
						<a4j:commandLink styleClass="botaoAlteracao" value="#{msg.botao_alteracao_medicamento}" action="#{controleMedicamentos.alterarMedicamento}"/>
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

<rich:modalPanel id="panel" width="350" height="100">
    <f:facet name="header">
        <h:panelGroup>
            <h:outputText value="Modal Panel"></h:outputText>
        </h:panelGroup>
    </f:facet>
    <f:facet name="controls">
        <h:panelGroup>
            <h:commandLink value="close" id="hidelink"/>
            <rich:componentControl for="panel" attachTo="hidelink" operation="hide" event="onclick"/>
        </h:panelGroup>
    </f:facet>
    <h:outputText value="This panel is called using Component Control Component"></h:outputText>
    <br/>
    <h:outputText value="Closure link (X) works also through Component Control"></h:outputText>
</rich:modalPanel>    
</f:view>    
</body> 
</html>