package cc.jtogashi.mapboxnavuxsupporthelper

import android.app.Application
import com.mapbox.dash.sdk.Dash

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Dash.init(
            context = this,
            accessToken = getString(R.string.mapbox_access_token)
        )
    }
}