var express = require('express');
var router = express.Router();
var Ticket = require('../models/Ticket');

router.get('/:code', function(req, res, next){
  Ticket.getTicketByCode(req.params.code, function(err, rows){
    if(err) {
      res.json(err);
    }
    else {
      res.json(rows[0]);
    }
  });
});

router.post('/', function(req, res, next){
  Ticket.addTicket(req.body, function(err, count){
    if(err) {
      res.json(err);
    }
    else {
    	res.json(req.body);
    }
  });
});

module.exports=router;