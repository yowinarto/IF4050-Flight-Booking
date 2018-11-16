var express = require('express');
var router = express.Router();
var Passenger = require('../models/Passenger');

router.get('/:id', function(req, res, next){
  Passenger.getPassengerById(req.params.id, function(err, rows){
    if(err) {
      res.json(err);
    }
    else {
      res.json(rows[0]);
    }
  });
});

router.post('/', function(req, res, next){
  Passenger.addPassenger(req.body, function(err, count){
    if(err) {
      res.json(err);
    }
    else {
    	res.json(req.body);
    }
  });
});

module.exports=router;