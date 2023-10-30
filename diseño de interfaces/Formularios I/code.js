
var oculto = true
document.getElementById("ojo").addEventListener("click", function(){
    
    if (oculto == true) {
        document.formu.clave.setAttribute("type", "text")
        oculto = false
        this.setAttribute("src", "img/ojo-invisible.svg")
    } else {
        document.formu.clave.setAttribute("type", "password")
        oculto = true
        this.setAttribute("src", "img/ojo-visible.svg")
    }
})