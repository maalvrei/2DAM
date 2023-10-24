function cajaLuz(){
    let nueva = document.createElement("div");
    nueva.setAttribute("id" , "luz")
    let fuente = this.src;
    console.log(fuente)
    nueva.innerHTML = '<img src="' + fuente + '">'
    document.body.appendChild(nueva)
}

var luz = document.getElementById("luz")
if(luz != null) {
    luz.addEventListener("click", function(){
        luz.remove()
    })
}


var imagenes = document.querySelectorAll("img")

console.log(imagenes)
for(i = 0 ; i < imagenes.length ; i++) {
    imagenes[i].addEventListener("click", cajaLuz)
}

// document.querySelector("img").addEventListener("click", cajaLuz)