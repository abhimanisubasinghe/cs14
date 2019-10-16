const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');

var app = express();

var logger = function(req, res, next) {
        console.log('Logging...');
        next();
    }
    //View Engine
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

//Body Parser Middleware
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.get('/', (req, res) => {
    res.render('index');
})

app.listen(5000, () => {
    console.log("Server is running on port 5000");
});