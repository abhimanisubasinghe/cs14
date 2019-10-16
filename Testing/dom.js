document.getElementById("demo").innerHTML = "This is first test";

document.getElementsByTagName("p").innerHTML = "This is second test";

//querySelector

let para = document.querySelector("#para"); //Using id
console.log(para);

para.innerHTML = "This is query selector text";

//querySelectorAll

let par = document.querySelectorAll(".para");
console.log(par);

par[1].innerHTML = "This is node 2 of querySelector all";
par[0].innerHTML = "text has been changed";

let sub = document.querySelector(".submit");

sub.style.backgroundColor = "Blue";
sub.style.fontSize = "3em";
sub.style.padding = "1.5em";