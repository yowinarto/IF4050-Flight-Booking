var mysql=require('mysql');
var connection=mysql.createPool({
	host:'localhost',
	user:'root',
	password:'root',
	database:'flight_booking'
});
module.exports=connection;