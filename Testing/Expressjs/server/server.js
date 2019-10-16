const express = require('express');
const router = require('./routes');
const app = express();

app.use(express.json());
app.use('/api/chirps', router);

app.listen(process.env.PORT || '5000', () => {

    console.log(`Server is running on port : ${process.env.PORT || '5000'}`)
});