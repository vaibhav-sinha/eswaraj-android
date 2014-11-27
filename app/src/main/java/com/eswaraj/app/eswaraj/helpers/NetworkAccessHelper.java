package com.eswaraj.app.eswaraj.helpers;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import javax.inject.Inject;

public class NetworkAccessHelper {
    @Inject
    private Context applicationContext;
    private RequestQueue requestQueue;

    public NetworkAccessHelper() {
        requestQueue = Volley.newRequestQueue(this.applicationContext);
    }

    public void submitNetworkRequest(String requestTag, Request request) {
        requestQueue.cancelAll(requestTag);
        requestQueue.add(request);
        request.setTag(requestTag);
    }
}