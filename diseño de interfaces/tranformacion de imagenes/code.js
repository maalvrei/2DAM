window.addEventListener("DOMContentLoaded", function() {
    let imagen = this.document.getElementById("imagen-principal").firstElementChild
    let ranges = this.document.querySelectorAll("input[type=range]")
    console.log(ranges)

    for (let range of ranges){
        let idPropiedad = range.id
        range.addEventListener("change", function() {
            console.log(range.value)
            imagen.style.filter = idPropiedad + "(" + range.value + "%)"
            range.nextElementSibling.innerHTML = range.value
        })
        
    }
})