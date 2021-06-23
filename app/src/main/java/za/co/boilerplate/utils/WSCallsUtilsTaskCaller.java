package za.co.boilerplate.utils;

import android.app.Activity;

public interface WSCallsUtilsTaskCaller {
    void taskCompleted(String response, int reqCode);

    Activity getActivity();
}
