package za.co.boilerplate.policies

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONObject
import za.co.boilerplate.MainActivity
import za.co.boilerplate.R
import za.co.boilerplate.databinding.PrivacyPolicyFragmentBinding
import za.co.boilerplate.utils.ConstantUtils
import za.co.boilerplate.utils.DTUtils
import za.co.boilerplate.utils.SharedPreferencesUtils
import kotlin.system.exitProcess

class PrivacyPolicyFrag : Fragment(R.layout.privacy_policy_fragment) {
    private lateinit var binding: PrivacyPolicyFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val privacyPolicy = """        <p style="text-align:left; margin:4%;">Your privacy and legal rights are important to us. It is Track My&#39;s policy to respect your privacy regarding any information we may collect from you.<br />
        <br />
        We only ask for personal information that is required for us to provide a service to you. We collect it by fair and lawful means, with your knowledge and consent. We also let you know why we&#39;re collecting it and how it will be used.<br />
        <br />
        We only retain the collected information for as long as necessary to provide you with your requested service. The data we store, we will protect within commercially acceptable means to prevent loss and theft, as well as unauthorized access, disclosure, copying, use or modification.<br />
        <br />
        We don&#39;t share any personally identifying information publicly or with third-parties, except when required to by law.<br />
        <br />
        Our website may link to external sites that are not operated by us. Please be aware that we have no control over the content and practices of these sites, and cannot accept responsibility or liability for their respective privacy policies.<br />
        <br />
        You are free to refuse our request for your personal information, with the understanding that we may be unable to provide you with some of your desired services.<br />
        <br />
        Your continued use of our app will be regarded as acceptance of our practices around privacy and personal information. If you have any questions about how we handle user data and personal information, feel free to contact us.<br />
        <br />
        <b><u>Personal and Sensitive Information Disclosure</u></b><br />
        To make use of the Track My app please note that we require and store the following information:<br />
        1. Your current location.<br />
        2. Device IMEI number.<br />
        3. Device health (Battery life, signal strength).<br />
        <br />
        This policy is effective as of 14 November 2020.<br />
        <br />
        By accepting these above terms for personal and sensitivity information disclosure as to how your data will be used you give us permission to save your data for the terms as described above.</p>"""
        binding.privacyPolicyTextView.movementMethod = ScrollingMovementMethod()
        binding.privacyPolicyTextView.text = Html.fromHtml(privacyPolicy)

        binding.exitButton.setOnClickListener {
            activity?.finishAffinity()
            exitProcess(0)
        }

        binding.acceptButton.setOnClickListener {
            try {
                val jsonObject = JSONObject()
                jsonObject.put("isAccepted", true)
                SharedPreferencesUtils.save(context, SharedPreferencesUtils.PRIVACY_POLICY_ACCEPTANCE, jsonObject)
                context!!.startActivity(Intent(activity, MainActivity::class.java))
            } catch (e: Exception) {
                Log.d(ConstantUtils.TAG, "Class: PrivacyPolicyFrag" +
                        "Method: onCreateView " +
                        "Error: ${e.message} " +
                        "CreatedTime: ${DTUtils.getCurrentDateTime()}")
            }
        }
    }
}