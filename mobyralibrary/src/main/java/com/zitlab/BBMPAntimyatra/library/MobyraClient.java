package com.zitlab.BBMPAntimyatra.library;

import android.os.Handler;
import android.os.Looper;

import com.zitlab.palmyra.ResponseCallback;
import com.zitlab.palmyra.http.MobyraClientBuilder;
import com.zitlab.palmyra.exception.PalmyraException;
import com.zitlab.palmyra.http.PalmyraRestClient;
import com.zitlab.palmyra.http.ResponseStatus;

/**
 * The type Mobyra client.
 */
public final class MobyraClient extends PalmyraRestClient {


    /**
     * Instantiates a new Mobyra client.
     *
     * @param builder the builder
     */
    public MobyraClient(MobyraClientBuilder builder) {
        super(builder);
    }


    @Override
    protected <T> void sendCallback(ResponseCallback callback, ResponseStatus status, T response, PalmyraException ex) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                callback.onMobyraResponse(status, response, ex);
            }
        });
    }

}
