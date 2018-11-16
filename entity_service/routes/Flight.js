var express = require('express');
var router = express.Router();
var Flight = require('../models/Flight');

router.get('/:id', function(req, res, next){
  Flight.getFlightById(req.params.id, function(err, rows){
    if(err) {
      res.json(err);
    }
    else {
      res.json(rows[0]);
    }
  });
});

router.get('/', function(req, res, next){
  Flight.getFlightByFilter(req.query, function(err, rows){
    if(err) {
      res.json(err);
    }
    else {
      res.json(rows);
    }
  });
});

module.exports=router;