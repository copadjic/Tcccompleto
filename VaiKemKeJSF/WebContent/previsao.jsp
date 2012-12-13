<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="previsao.css" media="all" />
<title>Previsão</title>
</head>
<body>

<h3 class="previsao">Previsão</h3>
<h:dataTable value="#{pesqueiroBean.pesqueiros}" var="pesq"  width="680" border="2" styleClass="tabelapesqueiros">
				<h:column class="bordaeespacopesq" footerClass="conhecpes" headerClass="conhecpes">
					<f:facet name="header" >Nome</f:facet>
					<h:outputLabel value="#{pesq.nome}" styleClass="conhecpes2"></h:outputLabel>
				</h:column>
				
				<h:column class="bordaeespacopesq" footerClass="conhecpes" headerClass="conhecpes">
					<f:facet name="header">Cidade</f:facet>
					<h:outputLabel value="#{pesq.cidade.nome}" styleClass="conhecpes2"></h:outputLabel>
					
				</h:column>

				<h:column class="bordaeespacopesq" footerClass="conhecpes" headerClass="conhecpes">
					<f:facet name="header">Estado</f:facet>
					<h:outputLabel value="#{pesq.cidade.estado.nome}" styleClass="conhecpes2"/>
				</h:column>
				
				<h:column class="bordaeespacopesq" footerClass="conhecpes3" headerClass="conhecpes3">
					<div class="conhecpes3">
					<f:facet name="header">Previsão</f:facet>
					<iframe src="#{pesq.previsao}" width="120" height="100" scrolling='no' frameborder='0'  marginheight='0' marginwidth='0'/>
					</div>
				</h:column>
				</h:dataTable>
	<table class="previsao">
	<tr>
	<td>Região Sudeste</td>
	</tr>
	<tr>
	<td>	
	<iframe class="previsao"src='http://selos.climatempo.com.br/selos/MostraSelo.php?CODCIDADE=558,107,84,321&SKIN=verde' scrolling='no' frameborder='0' width='150' height='170' marginheight='0' marginwidth='0'></iframe>
	</td>
	
	
	<td>Região Norte</td>
	<td>	
	<iframe src='http://selos.climatempo.com.br/selos/MostraSelo.php?CODCIDADE=343,347,6,232,25,39,593&SKIN=verde' scrolling='no' frameborder='0' width='150' height='170' marginheight='0' marginwidth='0'></iframe>
	</td>
	
	<td>Região Nordeste</td>
	<td>	
	<iframe src='http://selos.climatempo.com.br/selos/MostraSelo.php?CODCIDADE=256,264,334,94,259,60,56,384,8&SKIN=padrao' scrolling='no' frameborder='0' width='150' height='170' marginheight='0' marginwidth='0'></iframe>
	</td>
	</tr>
	<tr>
	<td>Região Centro-Oeste</td>
	<td>	
	<iframe src='http://selos.climatempo.com.br/selos/MostraSelo.php?CODCIDADE=88,218,212,61&SKIN=verde' scrolling='no' frameborder='0' width='150' height='170' marginheight='0' marginwidth='0'></iframe>
	</td>
	
	<td>Região Sul</td>
	<td>	
	<iframe src='http://selos.climatempo.com.br/selos/MostraSelo.php?CODCIDADE=363,377,271&SKIN=verde' scrolling='no' frameborder='0' width=150 height='170' marginheight='0' marginwidth='0'></iframe>
	</td>
	
	</tr>
	
	</table>

</body>
</html>