const db = require('../dbconnection');

const Booking = {
	getBookingById: function(id, callback) {
	  return db.query(`SELECT * FROM booking INNER JOIN passenger ON booking.passenger_id = passenger.id 
	  	WHERE booking.id=?`, [id], callback);
	},

	addBooking: function(b, callback) {
		return db.query(`
			INSERT INTO booking (passenger_id, num_of_passenger, total_price, flight_id) 
			VALUES (?,?,?,?)`,
			[b.passenger_id, b.num_of_passenger, b.total_price, b.flight_id], 
			callback
		);
	},

	deleteBookingById: function(id, callback) {
	  return db.query("DELETE FROM booking WHERE id=?", [id], callback);
	},
};

module.exports = Booking;