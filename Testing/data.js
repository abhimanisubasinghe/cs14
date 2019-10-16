// Get attribute values 

let nav = document.querySelectorAll(".navbar");

//getAttribute() method

console.log(nav[1].getAttribute("data-number"));


//Change class name

let toggle = document.querySelector(".toggle");

let color = function(flag) {
    if (flag) {
        toggle.className = "toggle_in";
    } else {
        toggle.className = "toggle_out";
    }
}

color(1);