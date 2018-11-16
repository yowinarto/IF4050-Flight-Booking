var express = require('express');
var router = express.Router();
var Booking = require('../models/Booking');

router.get('/:id', function(req, res, next){
  Booking.getBookingById(req.params.id, function(err, rows){
    if(err) {
      res.json(err);
    }
    else {
      res.json(rows[0]);
    }
  });
});

router.post('/', function(req, res, next){
  Booking.addBooking(req.body, function(err, count){
    if(err) {
      res.json(err);
    }
    else {
    	res.json(req.body);
    }
  });
});

router.delete('/:id', function(req, res, next){
  Booking.deleteBookingById(req.params.id, function(err, rows){
    if(err) {
      res.json(err);
    }
    else {
      res.json({message: "ok"});
    }
  });
});

module.exports=router;