var express = require('express');
var router = express.Router();
var request = require('request');
var bodyMessage = {
  "messageName" : "Confirm Payment",
  "businessKey" : "12345",
  "processVariables" : {
    "confirmation" : {
        "value" : "Success!",
        "type": "String"
    }
  },
  "resultEnabled" : true 
}
const soapRequest = require('easy-soap-request');
const fs = require('fs');
const url = 'http://167.205.35.211:8080/easypay/PaymentService';
const headers = {
  'user-agent': 'payment',
  'Content-Type': 'text/xml;charset=UTF-8',
  'soapAction': 'http://167.205.35.211:8080/easypay/PaymentService?wsdl',
};
//const xml = fs.readFileSync('request/begin-payment.xml', 'utf-8');

/* GET home page. */
router.get('/', function(req, res, next) {
  let paymentMethod = req.query.paymentMethod;
  let amount = req.query.amount;
  let service = req.query.service;
  let businessKey = req.query.businessKey;
  let xml = getXMLRequest(paymentMethod, amount);
  res.send(xml);
  request.post(
    {url: url,
    body : xml,
    headers: {'Content-Type': 'text/xml'}
    },
    function (error, response, body) {        
        if (!error) {
            console.log(body);
            bodyMessage["businessKey"] = businessKey;
            if (service == "payment"){
              bodyMessage["messageName"] = "Confirm Payment";
            } else if(service == "refund"){
              bodyMessage["messageName"] = "Confirm Refund";
            }
            request.post(
              {url: "http://178.128.80.25:8080/engine-rest/message",
              body : JSON.stringify(bodyMessage),
              headers: {'Content-Type': 'application/json'}
              },
              function (error, response, body) {        
                  if (!error) {
                      console.log("ok");    
                  }
              }
        }
    }
);
});

function getXMLRequest(paymentMethod, amount){
  let req = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.core.easypay.payphone/\">\n" +
   "<soapenv:Header/>\n"+
   "<soapenv:Body>\n"+
      "<ws:beginPayment>\n"+
         "<paymentMethodId>" + paymentMethod+ "</paymentMethodId>\n"+
         "<amount>" + parseFloat(amount) + " </amount>\n"+
      "</ws:beginPayment>\n" +
   "</soapenv:Body>\n" + 
"</soapenv:Envelope>\n";
  return req;
}

router.post('/', function(req, res, next) {
  res.send(req);
});

module.exports = router;