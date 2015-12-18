package com.bingofresh.plugins.baidutrace;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;

public class BaiduTrace extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    //Log.i(, "插件调用");
    JSONObject options = new JSONObject();
    if (action.equals("startTrace")) {
      try {
        options = args.getJSONObject(0);
      } catch (JSONException e) {
        //Log.v(TAG, "options 未传入");
      }
      callbackContext.success("1234567");
      //return getCurrentPosition(options, callbackContext);
      return true;
    } 
    return false;
  }
}
