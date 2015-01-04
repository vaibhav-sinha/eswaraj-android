package com.eswaraj.app.eswaraj.volley;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.eswaraj.app.eswaraj.base.BaseClass;
import com.eswaraj.app.eswaraj.config.Constants;
import com.eswaraj.app.eswaraj.datastore.Cache;
import com.eswaraj.app.eswaraj.events.GetLocationComplaintCountersEvent;
import com.eswaraj.app.eswaraj.helpers.NetworkAccessHelper;
import com.eswaraj.app.eswaraj.models.ComplaintCounter;
import com.eswaraj.web.dto.LocationDto;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;


public class LocationComplaintCountersRequest extends BaseClass {

    @Inject
    EventBus eventBus;
    @Inject
    Cache cache;
    @Inject
    NetworkAccessHelper networkAccessHelper;

    public void processRequest(Context context, LocationDto locationDto) {
        StringRequest request = new StringRequest(Constants.LOCATION_COUNTERS_URL + "/" +locationDto.getId(), createSuccessListener(context, locationDto), createErrorListener(context));
        request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, 3));
        networkAccessHelper.submitNetworkRequest("GetLocationComplaintCounters", request);
    }

    private Response.ErrorListener createErrorListener(final Context context) {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                GetLocationComplaintCountersEvent event = new GetLocationComplaintCountersEvent();
                event.setError(error.toString());
                eventBus.post(event);
            }
        };
    }

    private Response.Listener<String> createSuccessListener(final Context context, final LocationDto locationDto) {

        return new Response.Listener<String>() {
            @Override
            public void onResponse(String json) {
                Gson gson = new Gson();
                try {
                    List<ComplaintCounter> complaintCounters;
                    GetLocationComplaintCountersEvent event = new GetLocationComplaintCountersEvent();
                    complaintCounters = gson.fromJson(json, new TypeToken<List<ComplaintCounter>>(){}.getType());
                    event.setSuccess(true);
                    event.setComplaintCounters(complaintCounters);
                    eventBus.post(event);
                    //Update the cache
                    cache.updateLocationComplaintCounters(context, locationDto, json);
                } catch (JsonParseException e) {
                    GetLocationComplaintCountersEvent event = new GetLocationComplaintCountersEvent();
                    event.setError("Invalid json");
                    eventBus.post(event);
                }
            }
        };
    }
}
