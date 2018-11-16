var express = require('express');
var router = express.Router();
var Promo = require('../models/Promo');

router.get('/:code', function(req, res, next){
  Promo.getPromoByCode(req.params.code, function(err, rows){
    if(err) {
      res.json(err);
    }
    else {
      res.json(rows[0]);
    }
  });
});

router.get('/', function(req, res, next){
  Promo.getAllPromo(function(err, rows){
    if(err) {
      res.json(err);
    }
    else {
      res.json(rows);
    }
  });
});

router.post('/', function(req, res, next){
  Promo.addPromo(req.body, function(err, count){
    if(err) {
      res.json(err);
    }
    else {
    	res.json(req.body);
    }
  });
});

module.exports=router;