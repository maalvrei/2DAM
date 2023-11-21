var modificador = document.getElementById("modificador")
function filtrar() {
    document.getElementById("grande").style.filter = "brightness(" + modificador.value + "%)"
}

modificador.addEventListener("change",filtrar)