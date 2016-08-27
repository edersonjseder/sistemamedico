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
<title>Sistema Médico - Atendimentos</title>
<script type="text/javascript" src="/sistemamedico/javascript/jquery.maskedinput-1.2.1.js"></script> 
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
				<div id="sidebar_body" class="sidebar_body"><p><span><h:outputText value="#{msg.label_lateral_atendimento}" styleClass="estilo_texto_label_lateral"/></span></p></div>
                <div id="sidebar_bottom" class="sidebar_bottom"></div>
          	</div>
            <div id="text" class="text">
	            <div id="text_top" class="text_top">
	            	<div id="text_top_left" class="text_top_left"></div>
	                <div id="text_top_right" class="text_top_right"></div>
	            </div>

				<div id="text_body_cadastro_atendimento" class="text_body_cadastro_atendimento">
					<h:panelGrid border="0" columns="2">
						<h:outputText value="#{msg.crm_cadastro_atendimento}" styleClass="estilo_texto_label"/>
						<h:inputText id="crm" binding="#{controleAtendimentos.textCrm}" disabled="true" size="7" maxlength="140" styleClass="estilo_texto"/>
					
						<h:outputText value="#{msg.nome_medico_cadastro_atendimento}" styleClass="estilo_texto_label"/>
						<h:selectOneMenu id="medicos" style="width: 170px" styleClass="estilo_texto" value="#{controleAtendimentos.atendimentos.medicos.nome}" 
									     valueChangeListener="#{controleAtendimentos.preencheCampoTextoEspecialidade}" onchange="submit()">
							<f:selectItem itemValue="" itemLabel="Selecione..."/>											
							<f:selectItems value="#{controleAtendimentos.comboMedicos}"/>
							<a4j:support event="onchange" ajaxSingle="true" reRender="medicos"/>									
						</h:selectOneMenu>
						
						<h:outputText value="#{msg.especialidade_cadastro_atendimento}" styleClass="estilo_texto_label"/>
						<h:inputText id="especialidade" binding="#{controleAtendimentos.textEspecialidade}" disabled="true" size="30" maxlength="140" styleClass="estilo_texto"/>
						
						<h:outputText value="#{msg.nome_paciente_cadastro_atendimento}" styleClass="estilo_texto_label"/>
						<h:selectOneMenu id="pacientes" style="width: 170px" styleClass="estilo_texto" value="#{controleAtendimentos.atendimentos.pacientes.nomePaciente}"
									     valueChangeListener="#{controleAtendimentos.preencheCampoTextoInformacoesPaciente}" onchange="submit()">
							<f:selectItem itemValue="" itemLabel="Selecione..."/>											
							<f:selectItems value="#{controleAtendimentos.comboPacientes}"/>
							<a4j:support event="onchange" ajaxSingle="true" reRender="pacientes"/>									
						</h:selectOneMenu>
						
						<h:outputText value="#{msg.cpf_cadastro_atendimento}" styleClass="estilo_texto_label"/>
						<h:inputText id="cpf" binding="#{controleAtendimentos.textCpf}" disabled="true" size="11" maxlength="14" styleClass="estilo_texto">
							<rich:jQuery selector="#cpf" query="mask('999.999.999-99')" timing="onload"/>
						</h:inputText>
						
						<h:outputText value="#{msg.data_nascimento_cadastro_atendimento}" styleClass="estilo_texto_label"/>
						<rich:calendar id="dataNascimento" binding="#{controleAtendimentos.textDataNascimento}" disabled="true" inputSize="7" inputClass="estilo_texto" datePattern="dd/MM/yyyy" boundaryDatesMode="scroll"/>
						
						<h:outputText value="#{msg.data_cadastro_atendimento}" styleClass="estilo_texto_label"/>
						<rich:calendar id="dataAtendimento" binding="#{controleAtendimentos.textDataAtendimento}" value="#{controleAtendimentos.atendimentos.dataAtendimento}" inputSize="7" inputClass="estilo_texto" datePattern="dd/MM/yyyy" boundaryDatesMode="scroll"/>
						
						<h:outputText value="#{msg.hora_cadastro_atendimento}" styleClass="estilo_texto_label"/>
						<h:inputText id="horaAtendimento" size="4" value="#{controleAtendimentos.horarioAtendimento}" maxlength="5" styleClass="estilo_texto">
							<rich:jQuery selector="#horaAtendimento" query="mask('99:99')" timing="onload"/>
						</h:inputText>
						
						<h:outputText value="#{msg.observacoes_cadastro_atendimento}" styleClass="estilo_texto_label"/>
						<h:inputTextarea rows="7" cols="35" id="obs" value="#{controleAtendimentos.atendimentos.observacoes}" styleClass="estilo_texto"/>
						
						<f:verbatim>&nbsp;</f:verbatim>						
						<a4j:commandLink styleClass="botaoCadastroAtendimentos" value="#{msg.botao_cadastro_atendimento}" action="#{controleAtendimentos.inserirAtendimento}"/>
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