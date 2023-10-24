let contenidos = [
  {
    id: 1,
    titulo: "Mattotti 1",
    descripcion: "El cuadro número 1 de Mattotti",
    imagen: "lorenzo-mattotti-1.jpg"
  },
  {
    id: 2,
    titulo: "Mattotti 2",
    descripcion: "El cuadro número 2 de Mattotti",
    imagen: "lorenzo-mattotti-2.jpg"
  },
  {
    id: 3,
    titulo: "Mattotti 3",
    descripcion: "El cuadro número 3 de Mattotti",
    imagen: "lorenzo-mattotti-3.jpg"
  },
  {
    id: 4,
    titulo: "Mattotti 4",
    descripcion: "El cuadro número 4 de Mattotti",
    imagen: "lorenzo-mattotti-4.jpg"
  }
];

let caja = document.getElementById("caja");

for (let contenido of contenidos) {
  let ficha = document.createElement("div");
  ficha.setAttribute("class", "ficha");
  ficha.setAttribute("id", "ficha-" + contenido.id);
  
  let imagen = document.createElement("figure");
  imagen.innerHTML = '<img src="img/' + contenido.imagen + '" alt="Una obra de Mattotti">';
  
  let button = document.createElement("button");
  button.innerHTML = '<img src="img/eraser.svg">';
  
  ficha.appendChild(imagen);
  ficha.appendChild(button);
  
  button.addEventListener("click", function() {
    ficha.style.display = "none";
  });

  caja.appendChild(ficha);
}