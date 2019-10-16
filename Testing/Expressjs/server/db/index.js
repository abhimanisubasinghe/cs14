const mysql = require('mysql');

const pool = mysql.createPool({
    connectionLimit: 10,
    user: 'root',
    password: '',
    host: 'localhost',
    database: 'self&store'
});

let chirperdb = {};

chirperdb.all = () => {

    return new Promise((resolve, reject) => {

            pool.query("SELECT * FROM customers", (err, results) => {
                if (err) {
                    return reject(err);
                }
                return resolve(results);
            });
        }

    );
};

module.exports = chirperdb;