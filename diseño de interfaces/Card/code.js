var contenidos = [
  {
    id: 1,
    titulo: "3%",
    descripcion: "3 % es una serie de suspenso y ciencia ficción brasileña de Netflix. Es un reinicio de una serie web de 2011 del mismo nombre creada por Pedro Aguilera que tuvo su episodio piloto producido y subido a YouTube.Constituye el primer proyecto de producción original de Netflix en Brasil, y es una de las primeras series de Netflix producidas en un idioma distinto del inglés. 3 % está protagonizada por Bianca Comparato y João Miguel.",
    imagen: "3porciento.jpg"
  },
  {
    id: 2,
    titulo: "Cielo de media  noche",
    descripcion: "Augustine (George Clooney) es un solitario científico que se encuentra en el Ártico, y que trata de contactar con una nave espacial que intenta regresar a la Tierra. Augustine quiere impedir que Sully (Felicity Jones) y sus compañeros astronautas regresen a su hogar, donde se ha producido una misteriosa catástrofe global.",
    imagen: "cielodemedianoche.jpg"
  },
  {
    id: 3,
    titulo: "Aniquilación",
    descripcion: "Cuando su marido desaparece durante una misión secreta para regresar sin recordar nada, la bióloga Lena se une a una expedición a una misteriosa región acordonada por el gobierno de los Estados Unidos. El grupo, compuesto por 5 mujeres científicas, investiga la zona X, un intrigante lugar controlado por una poderosa fuerza alienígena. La zona X es un lugar al que han ido otras expediciones, pero del que ninguna ha vuelto.",
    imagen: "aniquilacion.jpg"
  }
]
let caja = document.getElementById("caja");

for (let contenido of contenidos) {

  let ficha = document.createElement("div");

  ficha.setAttribute("class", "ficha");

  ficha.setAttribute("id", "ficha-" + contenido.id);

  ficha.innerHTML = '<figure><img src="img/' + contenido.imagen + '" alt="Una cosa de Netflix" ></figure> <h3>' + contenido.titulo + '</h3><button>Ver</button>';

  caja.appendChild(ficha)
  
  

}
var completo = document.getElementById("completo")
function abrirContenido(){
  var botones = document.getElementById("caja").querySelectorAll("button");
  for (var boton of botones){
    boton.addEventListener("click", function(){
    completo.style.display = "block";
    //console.log(this.parentElement.firstElementChild.firstElementChild.src)
    var fuente = this.parentElement.firstElementChild.firstElementChild.src
    document.getElementById("imagen").src = fuente
    console.log(this.parentElement.children[1])
    })
  }
}
abrirContenido()

document.getElementById("cerrar").addEventListener("click", function(){
  completo.style.display = "none";
})
