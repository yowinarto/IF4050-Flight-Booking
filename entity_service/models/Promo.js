const db = require('../dbconnection');

const Promo = {
	getPromoByCode: function(code, callback) {
	  return db.query("SELECT * FROM promotion WHERE promo_code=?", [code], callback);
	},

	getAllPromo: function(callback) {
		return db.query("SELECT * FROM promotion", callback);
	},

	addPromo: function(p, callback) {
		return db.query(`
			INSERT INTO promotion (promo_code, available_from, available_until, discount) 
			VALUES (?,?,?,?)`,
			[p.promo_code, p.available_from, p.available_until, p.discount], 
			callback
		);
	},
};

module.exports = Promo;