// baidu yingyan
var cordova = require('cordova');
var SERVICE_NAME = 'BaiduTrace';
var ACTION_START_TRACE = 'startTrace';


var baiduyingyan = module.exports = {};

var idGenerator = 0;

baiduyingyan.startTrace = function (success, error, options) {
  return options;
  if (typeof sucess === 'object') {
    options = success;
  }
  if (typeof error === 'object') {
    options = error;
  }
  cordova.exec(function(args) {
    success.apply(null, args);
  }, error, SERVICE_NAME, ACTION_START_TRACE, [options]);
};
