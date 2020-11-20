package za.co.boilerplate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import org.json.JSONObject;
import za.co.boilerplate.policies.PrivacyPolicyFrag;
import za.co.boilerplate.utils.ConstantUtils;
import za.co.boilerplate.utils.DTUtils;
import za.co.boilerplate.utils.FragmentUtils;
import za.co.boilerplate.utils.SharedPreferencesUtils;
import za.co.boilerplate.utils.WSCallsUtilsTaskCaller;


public class MainActivity extends AppCompatActivity implements WSCallsUtilsTaskCaller
{
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireUI();

        displayPrivacyPolicy();

    }

    private void displayPrivacyPolicy()
    {
        try
        {
            JSONObject jsonObject = SharedPreferencesUtils.get(this, SharedPreferencesUtils.PRIVACY_POLICY_ACCEPTANCE);
            if(jsonObject == null)
            {
                setNavIcons(false, false);

                PrivacyPolicyFrag privacyPolicyFrag = new PrivacyPolicyFrag();
                FragmentUtils.startFragment(getSupportFragmentManager(), privacyPolicyFrag, R.id.fragContainer, getSupportActionBar(), "Privacy Policy", true, false, true, null);
            }else
            {

            }


        }catch(Exception e)
        {
            Log.e(ConstantUtils.TAG, "\nError: " + e.getMessage()
                    + "\nMethod: MainActivity - displayPrivacyPolicy"
                    + "\nCreatedTime: " + DTUtils.getCurrentDateTime());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu, menu);


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.settings:
            {


                break;
            }
            default:
            {
                //unknown
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void wireUI()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

    }


    public void setNavIcons(boolean home, boolean menu)
    {
        if(home)
        {

        }else
        {

        }

        if(menu)
        {

        }else
        {

        }
    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public void taskCompleted(String response, int reqCode) {
        if(response != null)
        {

        }
    }
}
