const boton = document.getElementById("play")
function reproducir() {
    const video = document.getElementById("perrito")
    
    if (video.paused || video.ended) {
        video.play()
        boton.firstElementChild.src = "img/pause.svg"
    } else {
        video.pause()
        boton.firstElementChild.src = "img/play.svg"
    }
}

boton.addEventListener("click", reproducir)
/*document.getElementById("play").addEventListener("click", function() {
    document.getElementById("perrito").play()
})

document.getElementById("pause").addEventListener("click", function() {
    document.getElementById("perrito").pause()
})*/
