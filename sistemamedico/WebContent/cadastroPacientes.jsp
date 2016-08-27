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
<title>Sistema Médico - Cadastro Pacientes</title> 
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
				<div id="sidebar_body" class="sidebar_body"><p><span><h:outputText value="#{msg.label_lateral_cadastro_pacientes}" styleClass="estilo_texto_label_lateral"/></span></p></div>
                <div id="sidebar_bottom" class="sidebar_bottom"></div>
          	</div>
            <div id="text" class="text">
	            <div id="text_top" class="text_top">
	            	<div id="text_top_left" class="text_top_left"></div>
	                <div id="text_top_right" class="text_top_right"></div>
	            </div>

				<div id="text_body_cadastro_paciente" class="text_body_cadastro_paciente">
					<h:panelGrid border="0" columns="3">
						<h:panelGroup>
							<h:outputText value="#{msg.nome_cadastro_pacientes}" styleClass="estilo_texto_label"/>
							<h:inputText id="nome" size="53" maxlength="60" styleClass="estilo_texto" value="#{controlePacientes.paciente.nomePaciente}"/>
						</h:panelGroup>
						<h:panelGroup>
							<h:panelGroup>
								<h:outputText value="#{msg.rg_cadastro_pacientes}" styleClass="estilo_texto_label"/>
								<h:inputText id="rg" size="10" maxlength="12" styleClass="estilo_texto" value="#{controlePacientes.paciente.rgPaciente}">
									<rich:jQuery selector="#rg" query="mask('99.999.999-9')" timing="onload"/>
								</h:inputText>
							</h:panelGroup>
							<h:panelGroup>
								<h:outputText value="#{msg.cpf_cadastro_pacientes}" styleClass="estilo_texto_label"/>
								<h:inputText id="cpf" size="10" maxlength="14" styleClass="estilo_texto" value="#{controlePacientes.paciente.cpfPaciente}">
									<rich:jQuery selector="#cpf" query="mask('999.999.999-99')" timing="onload"/>
								</h:inputText>
							</h:panelGroup>
							<h:panelGroup>
								<h:outputText value="#{msg.sexo_cadastro_medico}" styleClass="estilo_texto_label"/>
								<h:selectOneMenu id="sexo" style="width: 90px" value="#{controlePacientes.paciente.sexoPaciente}" styleClass="estilo_texto">
									<f:selectItem itemValue="Masculino" itemLabel="Masculino"/>
									<f:selectItem itemValue="Feminino" itemLabel="Feminino"/>
								</h:selectOneMenu>
							</h:panelGroup>
						</h:panelGroup>
						
						<h:panelGroup>
							<h:outputText value="#{msg.nasc_cadastro_pacientes}" styleClass="estilo_texto_label"/>
							<rich:calendar id="nasc" inputSize="6" inputClass="estilo_texto" datePattern="dd/MM/yyyy" boundaryDatesMode="scroll" value="#{controlePacientes.paciente.dataNascimento}"/>
						</h:panelGroup>
					</h:panelGrid>
					
					<h:panelGrid border="0" columns="2">
						<h:panelGroup>
							<h:outputText value="#{msg.endereco_cadastro_pacientes}" styleClass="estilo_texto_label"/>
							<h:inputText id="endereco" size="74" maxlength="80" styleClass="estilo_texto" value="#{controlePacientes.paciente.enderecoPaciente}"/>
						</h:panelGroup>
						<h:panelGroup>
							<h:panelGroup>
								<h:outputText value="#{msg.bairro_cadastro_pacientes}" styleClass="estilo_texto_label"/>
								<h:inputText id="bairro" size="31" maxlength="40" styleClass="estilo_texto" value="#{controlePacientes.paciente.bairroPaciente}"/>
							</h:panelGroup>
							<h:panelGroup>
								<h:outputText value="#{msg.cep_cadastro_pacientes}" styleClass="estilo_texto_label"/>
								<h:inputText id="cep" size="5" maxlength="9" styleClass="estilo_texto" value="#{controlePacientes.paciente.cepPaciente}">
									<rich:jQuery selector="#cep" query="mask('99999-999')" timing="onload"/>
								</h:inputText>
							</h:panelGroup>
						</h:panelGroup>
					</h:panelGrid>
					
					<h:panelGrid border="0" columns="3">
						<h:panelGroup>
							<h:outputText value="#{msg.cidade_cadastro_pacientes}" styleClass="estilo_texto_label"/>
							<h:inputText id="cidade" size="42" maxlength="90" styleClass="estilo_texto" value="#{controlePacientes.paciente.cidadePaciente}"/>
						</h:panelGroup>
						
						<h:panelGroup>
							<h:panelGroup>
								<h:outputText value="#{msg.estado_cadastro_pacientes}" styleClass="estilo_texto_label"/>
								<h:selectOneMenu id="estado" style="width: 150px" styleClass="estilo_texto"
								                 valueChangeListener="#{controlePacientes.preencheCampoTextoUf}" onchange="submit()">
									<f:selectItem itemValue="" itemLabel="Selecione..."/>											
									<f:selectItems value="#{controlePacientes.comboEstados}"/>
									<a4j:support event="onchange" ajaxSingle="true" reRender="estado"/>									
								</h:selectOneMenu>
							</h:panelGroup>
							<f:verbatim>&nbsp;</f:verbatim>
							<h:panelGroup>
								<h:outputText value="#{msg.uf_cadastro_pacientes}" styleClass="estilo_texto_label"/>
								<h:inputText id="uf" binding="#{controlePacientes.textUf}" size="2" disabled="true" maxlength="2" styleClass="estilo_texto"/>
							</h:panelGroup>
						</h:panelGroup>
						
						<h:panelGroup>
							<h:panelGroup>
								<h:outputText value="#{msg.fone_cadastro_pacientes}" styleClass="estilo_texto_label"/>
								<h:inputText id="telefone" size="9" maxlength="13" styleClass="estilo_texto" value="#{controlePacientes.paciente.telefoneResidencial}">
									<rich:jQuery selector="#telefone" query="mask('(99)9999-9999')" timing="onload"/>
								</h:inputText>
							</h:panelGroup>
							<f:verbatim>&nbsp;</f:verbatim>
							<h:panelGroup>
								<h:outputText value="#{msg.celular_cadastro_pacientes}" styleClass="estilo_texto_label"/>
								<h:inputText id="celular" size="9" maxlength="13" styleClass="estilo_texto" value="#{controlePacientes.paciente.telefoneCelular}">
									<rich:jQuery selector="#celular" query="mask('(99)9999-9999')" timing="onload"/>
								</h:inputText>
							</h:panelGroup>
						</h:panelGroup>
						
						<h:panelGroup>
							<h:outputText value="#{msg.mae_cadastro_pacientes}" styleClass="estilo_texto_label"/>
							<h:inputText id="mae" size="44" maxlength="90" styleClass="estilo_texto" value="#{controlePacientes.paciente.nomeMae}"/>
						</h:panelGroup>
						
						<h:panelGroup>
							<h:outputText value="#{msg.pai_cadastro_pacientes}" styleClass="estilo_texto_label"/>
							<h:inputText id="pai" size="35" maxlength="90" styleClass="estilo_texto" value="#{controlePacientes.paciente.nomePai}"/>
						</h:panelGroup>
						
						<a4j:commandLink styleClass="botaoCadastroPacientes" value="#{msg.botao_cadastro_medico}" action="#{controlePacientes.inserirPaciente}"/>
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