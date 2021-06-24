package za.co.boilerplate.utils

import android.content.Context
import android.location.*
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.model.LatLng
import za.co.boilerplate.utils.DTUtils.getCurrentDateTime
import za.co.boilerplate.utils.MathUtils.precision
import java.util.*

class LocationUtils(private val context: Context?) {
    private var locationManager: LocationManager? = null
    private var locationListener: LocationListener? = null
    var currentLocation: Location? = null

    init {
        startLocationServices()
    }

    private fun startLocationServices() {
        if (locationManager == null) {
            initializeLocationServices()
            startLocationManager()
        }
    }

    private fun initializeLocationServices() {
        if (context != null) {
            if (locationManager == null) {
                locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            }
            if (locationListener == null) {
                locationListener = object : LocationListener {
                    override fun onLocationChanged(location: Location) {
                        currentLocation = location
                    }

                    override fun onProviderDisabled(provider: String) {}
                    override fun onProviderEnabled(provider: String) {}
                    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
                }
            }
        }
    }

    private fun startLocationManager() {
        try {
            locationManager!!.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 5f, locationListener!!)
        } catch (e: SecurityException) {
            Log.e(TAG, "Error: ${e.message} " +
                    "Method: LocationUtils - startLocationManager " +
                    "CreatedTime: ${getCurrentDateTime()}")
        }
    }

    companion object {
        private const val TAG = "LocationUtils"
        fun getAddress(context: Context?, latLng: LatLng?): String? {
            var toReturn: String? = null
            try {
                if (context != null && latLng != null) {
                    val geocoder: Geocoder
                    val addresses: List<Address>
                    geocoder = Geocoder(context, Locale.getDefault())
                    addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1) // Here 1 represent max location result to returned, by documents it recommended 1 to 5
                    toReturn = addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                    val city = addresses[0].locality
                    val state = addresses[0].adminArea
                    val country = addresses[0].countryName
                    val postalCode = addresses[0].postalCode
                    val knownName = addresses[0].featureName // Only if available else return NULL
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error: ${e.message} " +
                        "Method: LocationUtils - getAddress " +
                        "CreatedTime: ${getCurrentDateTime()}")
            }
            return toReturn
        }

        fun msToKmh(ms: Double?): Double? {
            var toReturn: Double? = null
            if (ms != null) {
                toReturn = precision(ms * 3.6)
            }
            return toReturn
        }
    }
}