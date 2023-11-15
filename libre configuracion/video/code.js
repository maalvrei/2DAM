const boton = document.getElementById("boton")
const accion = document.getElementById("video")
const video = document.getElementById("perrito")

function actualizaMomento() {
    var estado = video.currentTime
    document.getElementById("salida").innerHTML = Math.floor(estado)
}

setInterval(actualizaMomento, 1000)

function reproducir() {
    
    if (video.paused || video.ended) {
        video.play()
        boton.src = "img/pause.svg"
    } else {
        video.pause()
        boton.src = "img/play.svg"
    }
}

boton.addEventListener("click", reproducir)
