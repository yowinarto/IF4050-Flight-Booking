const db = require('../dbconnection');

const Flight = {
	getFlightById: function(id, callback) {
	  return db.query("SELECT * FROM flight WHERE id=?", [id], callback);
	},

	getFlightByFilter: function(filter, callback) {
		let where = 'WHERE '
		if (filter.date_flight) {
			where += `date_flight='${filter.date_flight}' AND `
		}
		if (filter.class) {
			where += `class='${filter.class}' AND `
		}
		if (filter.origin) {
			where += `origin='${filter.origin}' AND ` 
		}
		if (filter.destination) {
			where += `destination='${filter.destination}' AND `
		}
		if (filter.time_flight) {
			where += `time_flight='${filter.time_flight}' AND `
		}
		if (filter.price) {
			where += `price<${filter.price} AND `
		}
		if (where.length <= 6) where = '' //no filter
		else where = where.slice(0, -5) //remove last AND

		return db.query("SELECT * from flight " + where, callback);
	},
};

module.exports = Flight;