// baidu yingyan
var exec = require('cordova/exec');
var SERVICE_NAME = 'BaiduTrace';
var ACTION_START_TRACE = 'startTrace';


var baiduyingyan = module.exports = {};

var idGenerator = 0;


baiduyingyan.startTrace = function(success, error) {
    exec(success, error, SERVICE_NAME, ACTION_START_TRACE, []);
};
