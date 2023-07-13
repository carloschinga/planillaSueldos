$(function () {
    $("#btnIngresar").click(function () {
        let login = $("#txtLogin").val();
        let password = $("#txtPassword").val();
        let parametro = {login: login,password:password};
        $.getJSON("validar", parametro, function (data) {
            if(data.resultado==="ok")
                $(location).attr('href','principal.html');
            else
                alert("error");
        });
    });
});