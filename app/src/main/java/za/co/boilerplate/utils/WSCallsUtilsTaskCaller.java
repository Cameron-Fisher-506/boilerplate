package za.co.boilerplate.utils;

import android.app.Activity;

public interface WSCallsUtilsTaskCaller
{
    public void taskCompleted(String response, int reqCode);
    public Activity getActivity();
}