const db = require('../dbconnection');

const Ticket = {
	getTicketByCode: function(code, callback) {
	  return db.query(`SELECT * FROM ticket INNER JOIN passenger ON ticket.passenger_id = passenger.id
	  	INNER JOIN booking ON ticket.booking_id = booking.id
	  	WHERE ticket_code=?`, [code], callback);
	},

	addTicket: function(t, callback) {
		return db.query(`
			INSERT INTO ticket (ticket_code, passenger_id, booking_id) 
			VALUES (?,?,?)`,
			[t.ticket_code, t.passenger_id, t.booking_id], 
			callback
		);
	},
};

module.exports = Ticket;