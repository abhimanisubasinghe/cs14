/*
//This keyword

const obj = {
    name: "Kai",
    greeting: function() { return ("Hello! I'm " + this.name); }
};

console.log(obj.greeting());

//Destructing arguments

const arry = [1, 2, 3, 4, 5];

function add([a, b, c, d, e]) {

    return a * b * c * d * e;
}

console.log(add(arry));


*/
//Closure 

function Counter() {

    let count = 0;
    return function() {

        return count++;
    };
}

let counter = Counter();

console.log(counter());
console.log(counter());
console.log(counter());