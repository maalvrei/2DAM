function proporcionar() {
var caja = document.getElementById("caja");
var ancho = caja.offsetWidth;
var alto = ancho * 0.61;
caja.style.height = alto + "px";
}

proporcionar();

window.addEventListener("resize", proporcionar)