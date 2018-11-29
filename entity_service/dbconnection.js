var mysql=require('mysql');
var connection=mysql.createPool({
	host:'localhost',
	user:'root',
	password:'123456',
	database:'flight_booking'
});
module.exports=connection;