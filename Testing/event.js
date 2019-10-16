/*

let modify = function() {

    document.querySelector(".para").style.fontSize = "3em";
    document.querySelector(".para").style.color = "tomato";

}



document.querySelector(".btn").addEventListener("click", modify); //Do not use the paranthesis after function name. Otherwise it will call the function even before the event.

*/

//Create focus event

let text = document.querySelector(".text");

let form = document.getElementById("form");

form.addEventListener("focus", function(event) {

    console.log(event.target);
});

text.addEventListener("focus", function(event) {

    console.log('Inside the inner element');
});