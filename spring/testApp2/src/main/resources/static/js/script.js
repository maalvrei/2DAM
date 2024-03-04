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
    var formulario = document.getElementById("formularioSC");

    formulario.addEventListener("submit", function(event) {
        var enunciado = document.getElementById("enunciadoSC").value.trim();
        var respuesta1 = document.getElementById("respuesta1sc").value.trim();
        var respuesta2 = document.getElementById("respuesta2sc").value.trim();
        var respuesta3 = document.getElementById("respuesta3sc").value.trim();
        var respuesta4 = document.getElementById("respuesta4sc").value.trim();

        if (enunciado === "") {
            alert("Hay un error en el formato de la pregunta que estás intentando crear. Por favor, revísela y vuelva a intentarlo.");
            event.preventDefault(); // Evita que el formulario se envíe
        } else if (respuesta1 === "" || respuesta2 === "" || respuesta3 === "" || respuesta4 === "") {
            alert("Hay un error en el formato de la pregunta que estás intentando crear. Por favor, revísela y vuelva a intentarlo.");
            event.preventDefault(); // Evita que el formulario se envíe
        }
    });
});
