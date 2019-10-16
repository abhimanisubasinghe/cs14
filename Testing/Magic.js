// export functions using export keyword

function sum(a, b) {

    multi(a, b);
    console.log(a + b);

}

let multi = (a, b) => {

    console.log(a * b);
}

export { sum, multi };