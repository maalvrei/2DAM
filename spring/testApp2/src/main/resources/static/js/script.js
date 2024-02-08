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