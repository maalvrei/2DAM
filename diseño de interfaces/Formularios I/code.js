    var oculto = true;
document.getElementById("ojo").addEventListener("click", function(){

    if( oculto == true){
        document.formu.clave.setAttribute("type", "text")
        this.setAttribute("src", "img/ojo-invisible.svg")
        oculto = false
        
    }else{
        document.formu.clave.setAttribute("type", "password")
        this.setAttribute("src", "img/ojo-visible.svg")
        oculto = true
    }

})

let datos = new URLSearchParams(window.location.search)

let nombre = datos.get("nombre");
let apellidos = datos.get("apellidos");
let email = datos.get("email");
let telefono = datos.get("telefono");



document.formu.nombre.value = nombre;
var tnombre = document.getElementById("tnombre")
if (tnombre) {
    tnombre.innerHTML = nombre
}
document.formu.apellidos.value = apellidos;
var tapellidos = document.getElementById("tapellidos")
if (tapellidos) {
    tapellidos.innerHTML = apellidos
}
document.formu.email.value = email;
var temail = document.getElementById("temail")
if (temail) {
    temail.innerHTML = email
}
document.formu.telefono.value = telefono;
var ttelefono = document.getElementById("ttelefono")
if (ttelefono) {
    ttelefono.innerHTML = telefono
}

document.formu.addEventListener("submit", function(e){
    var ExpRegNomApe="^[A-ZÑa-zñáéíóúÁÉÍÓÚ'° ]+$"
    let validaNombre = document.formu.nombre.value.match(ExpRegNomApe) ? true : false
    let validaApellidos = document.formu.apellidos.value.match(ExpRegNomApe) ? true : false
    if (validaNombre == false || validaApellidos == false) {
        document.getElementById("mensaje").innerHTML = "Revisa los campos del formulario"
        if (validaNombre == false) {
            document.formu.nombre.parentElement.classList.add("borde")
        }
        if (validaApellidos == false) {
            document.formu.apellidos.parentElement.classList.add("borde")
        }
        e.preventDefault()
    }
})