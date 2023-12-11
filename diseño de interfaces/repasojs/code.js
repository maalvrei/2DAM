var titular = document.getElementById("titular")
console.log(titular.innerHTML)

var divs = document.getElementsByTagName("div")
console.log(divs[1].innerHTML)

/*for (let div of divs) {
    console.log(div.innerHTML)
}*/

let sectiondivs = document.querySelectorAll("section div")

console.log(sectiondivs[0].innerHTML)

/*function abreSubmenu() {
    let submenu = document.getElementsByClassName("submenu")
    submenu[0].style.display = "block"
    submenu[0].parentElement.classList.add("padre")
    submenu[1].style.display = "block"
    submenu[1].parentElement.classList.add("padre")
}*/
let aes = document.querySelectorAll("nav>ul>li>a")

let cerrado = true

for(let a of aes) {
    a.addEventListener("click", function() {
        
        if(cerrado == true) {
            a.nextElementSibling.style.display = "block"
            cerrado = false
        }
        else {
            a.nextElementSibling.style.display = "none"
            cerrado = true
        }
    })
}
