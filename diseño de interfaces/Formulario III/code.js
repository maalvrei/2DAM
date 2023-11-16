window.addEventListener("DOMContentLoaded", function() {
    this.setTimeout(function(){
        //document.getElementById("pantalla1").style.display = "none"
        //document.getElementById("pantalla2").style.display = "block"
        cambiaPantalla(2) 
    },1000)
    
    
})

function cambiaPantalla(numero) {
    pantallas = document.getElementsByClassName("pantalla")
    for (pantalla of pantallas) {
        pantalla.style.display = "none"
    }
    document.getElementById("pantalla" + numero).style.display = "block"
}

