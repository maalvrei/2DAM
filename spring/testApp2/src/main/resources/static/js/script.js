['respuesta1sc', 'respuesta2sc', 'respuesta3sc', 'respuesta4sc'].forEach(function(id) {
    var campo = document.getElementById(id);
    
    campo.addEventListener('blur', function() {
        // Agregar '|' al final del valor
        if (!this.value.trim().endsWith('   ')) {
            this.value = this.value.trim() + '   ';
        }
    });

    campo.addEventListener('focus', function() {
        // Eliminar el último '|' si existe al final del valor
        if (this.value.trim().endsWith('   ')) {
            this.value = this.value.trim().slice(0, -1);
        }
    });
});
['respuesta1mc', 'respuesta2mc', 'respuesta3mc', 'respuesta4mc'].forEach(function(id) {
    var campo = document.getElementById(id);
    
    campo.addEventListener('blur', function() {
        // Agregar '|' al final del valor
        if (!this.value.trim().endsWith('   ')) {
            this.value = this.value.trim() + '   ';
        }
    });

    campo.addEventListener('focus', function() {
        // Eliminar el último '|' si existe al final del valor
        if (this.value.trim().endsWith('   ')) {
            this.value = this.value.trim().slice(0, -1);
        }
    });
});
['respuestaCorrecta1mc', 'respuestaCorrecta2mc', 'respuestaCorrecta3mc', 'respuestaCorrecta4mc'].forEach(function(id) {
    var campo = document.getElementById(id);
    
    campo.addEventListener('blur', function() {
        if (!this.value.trim().endsWith('   ')) {
            this.value = this.value.trim() + '   ';
        }
    });

    campo.addEventListener('focus', function() {
        if (this.value.trim().endsWith('   ')) {
            this.value = this.value.trim().slice(0, -1);
        }
    });
});

document.addEventListener("DOMContentLoaded", function() {
        const formulario = document.getElementById("formularioVF");
        formulario.addEventListener("submit", function(event) {
            const enunciadoInput = document.querySelector("#formularioVF input[name='enunciado']");
            const enunciadoValue = enunciadoInput.value.trim();
            const mensajeError = document.getElementById("mensajeError");

            if (enunciadoValue === "") {
                event.preventDefault(); // Evita que el formulario se envíe

                // Verificamos si el mensaje de error ya está presente
                if (!mensajeError) {
                    // Creamos un elemento div para mostrar el mensaje de error
                    const mensajeErrorNuevo = document.createElement("div");
                    mensajeErrorNuevo.textContent = "Debes introducir un enunciado";
                    mensajeErrorNuevo.style.color = "red";
                    mensajeErrorNuevo.style.display = "inline-block"; // Alinea el mensaje a la izquierda
                    mensajeErrorNuevo.style.marginTop = "5px";
                    mensajeErrorNuevo.style.fontSize = "15px";
                    mensajeErrorNuevo.id = "mensajeError";

                    // Insertamos el mensaje de error después del input de enunciado
                    enunciadoInput.parentNode.insertBefore(mensajeErrorNuevo, enunciadoInput.nextSibling);
                }
            } else {
                // Si el enunciado está presente y hay un mensaje de error, lo eliminamos
                if (mensajeError) {
                    mensajeError.parentNode.removeChild(mensajeError);
                }
            }
        });
    });