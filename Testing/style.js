let sub = document.querySelector("input[type=submit]");
let but = document.querySelector("input[type=button]");

//To add CSS class to elements

sub.classList.add("submit");
but.classList.add("sub");

//Create new elements

let p1 = document.createElement("p");
let p2 = document.createElement("p");

p1.textContent = "This is first paragraph";
p2.textContent = "This is second paragraph";

//Add the new elements to DOM
let content = document.querySelector(".content");

content.appendChild(p1);
content.appendChild(p2);

// Adding attributes to elements
p1.setAttribute("class", "para1");
p2.setAttribute("id", "para2");

//Removing attributes to the element
p2.removeAttribute("id");