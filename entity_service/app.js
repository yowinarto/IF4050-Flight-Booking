const express = require('express');
const logger = require('morgan');
const bodyParser = require('body-parser');
const cors = require('cors');
const http = require('http');
const routes = require('./routes/index');
const Passenger = require('./routes/Passenger');
const Flight = require('./routes/Flight');
const Promo = require('./routes/Promo');
const Booking = require('./routes/Booking');
const Ticket = require('./routes/Ticket');

const app = express();
app.use(cors());
app.use(logger('dev'));
app.use(bodyParser.json({limit: '50mb'}));
app.use(bodyParser.urlencoded({limit: '50mb', extended: false }));

app.use('/', routes);
app.use('/passenger', Passenger);
app.use('/flight', Flight);
app.use('/promo', Promo);
app.use('/booking', Booking);
app.use('/ticket', Ticket);

const port = 8081;
app.set('port', port);

const server = http.createServer(app);
server.listen(port);
server.on('listening', function(){
	const addr = server.address();
  const bind = typeof addr === 'string'
    ? 'pipe ' + addr
    : 'port ' + addr.port;
  console.log('Listening on ' + bind);
});
