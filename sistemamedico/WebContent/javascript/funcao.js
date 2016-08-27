function checaEmail(nform) {
	if (nform.campoUsuario.value == "") {
		alert("Campo Usuario Obrigatorio");
		nform.campoUsuario.focus();
		return false;
	}
	if (nform.campoSenha.value == "") {
		alert("Campo Senha Obrigatorio");
		nform.campoSenha.focus();
		return false;
	}
	
	if (nform.campoSenhaConfirm.value == "") {
		alert("Campo Senha Obrigatorio");
		nform.campoSenhaConfirm.focus();
		return false;
	}
	
	if (nform.campoEmail.value == "") {
		alert("Informe seu e-mail.");
		nform.campoEmail.focus();
		return false;
	}
	
	if(nform.campoEmail.value.indexOf("@") == -1) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf(".") < 1) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf(" ") != -1) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf("zipmeil.com") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf("hotmeil.com") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf(".@") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf("@.") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf(".com.br.") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf("/") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf("[") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf("]") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf("(") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf(")") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
	if(nform.campoEmail.value.indexOf("..") > 0) {
		alert("O e-mail informado parece não estar correto.");
		nform.campoEmail.focus();
		return false;
	}
}