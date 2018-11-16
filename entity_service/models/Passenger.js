const db = require('../dbconnection');

const Passenger = {
	getPassengerById: function(id, callback) {
	   return db.query("SELECT * FROM passenger WHERE id=?", [id], callback);
	},

	addPassenger: function(passenger, callback) {
		return db.query(`
			INSERT INTO passenger (fullname, phone_number, email, birthdate, gender) 
			VALUES (?,?,?,?,?)`,
			[passenger.fullname, passenger.phone_number, passenger.email, passenger.birthdate, passenger.gender], 
			callback
		);
	},

	// deletePassenger: 	function(id, callback) {
	//   return db.query("DELETE FROM passenger WHERE id=?", [id], callback);
	// },

	// updatePassenger: 	function(id, passenger, callback) {
	//   return db.query("UPDATE passenger set Title=?,Status=? WHERE id=?",
	//   	[passenger.Title, passenger.Status,id], callback);
	// }
};

module.exports = Passenger;