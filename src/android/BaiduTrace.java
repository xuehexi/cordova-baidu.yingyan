package com.xuehexi.hello;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;

import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.OnStartTraceListener;
import com.baidu.trace.OnStopTraceListener;
import com.baidu.trace.OnTrackListener;
import com.baidu.trace.Trace;
import com.baidu.trace.OnGeoFenceListener;
import com.baidu.trace.OnEntityListener;


public class BaiduTrace extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    //Log.i(, "插件调用");
    JSONObject options = new JSONObject();
    if (action.equals("startTrace")) {
      try {
        options = args.getJSONObject(0);
      } catch (JSONException e) {
        //Log.v(TAG, "options 未传入");
      }
Context ctx = cordova.getActivity().getApplicationContext();
//实例化轨迹服务客户端
LBSTraceClient client = new LBSTraceClient(ctx);
//鹰眼服务ID
long serviceId  = 105386; //开发者创建的鹰眼服务ID
//entity标识
String entityName = "mycar";
//轨迹服务类型（0 : 不上传位置数据，也不接收报警信息； 1 : 不上传位置数据，但接收报警信息；2 : 上传位置数据，且接收报警信息）
int  traceType = 2;
//实例化轨迹服务
Trace trace = new Trace(ctx, serviceId, entityName, traceType);
//实例化开启轨迹服务回调接口
OnStartTraceListener  startTraceListener = new OnStartTraceListener() {       
    //开启轨迹服务回调接口（arg0 : 消息编码，arg1 : 消息内容，详情查看类参考）
     @Override
     public void onTraceCallback(int arg0,  String arg1) {
     	callbackContext.success(arg1);             
     }
    //轨迹服务推送接口（用于接收服务端推送消息，arg0 : 消息类型，arg1 : 消息内容，详情查看类参考）
     @Override
     public void onTracePushCallback(byte arg0, String arg1) {
     }
};
//开启轨迹服务
client.startTrace(trace, startTraceListener);



      
      //return getCurrentPosition(options, callbackContext);
      return true;
    } 
    return false;
  }
}
