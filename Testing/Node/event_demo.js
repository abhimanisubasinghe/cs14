const EventEmitter = require('events');

class MyEmitter extends EventEmitter {}

const myEmitter = new MyEmitter();

myEmitter.on('event', () => { console.log('Event fired!'); });
myEmitter.on('eve', () => { console.log("test event fired!"); })


myEmitter.emit('eve');
myEmitter.emit('event');