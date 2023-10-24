var abierto = false
const menu  = document.getElementById("menu")
function activarMenu(){
    // document.getElementById("menu").classList.toggle("visible");
    if(abierto == false){
        menu.style.right = "0"
        abierto = true
    } else {
        menu.style.right = "-100vw"
        abierto = false
    }
}
document.getElementById("boton").addEventListener("click", activarMenu)

let listado = document.querySelectorAll("#menu>li")

console.log(listado)

for (listado of listado) {
    let submenu = listado.querySelector(".submenu")
    if(submenu != null) {
        submenu.style.display = "none"
        submenu.parentElement.firstChild.classList.add("tieneSubmenu")
    }
}