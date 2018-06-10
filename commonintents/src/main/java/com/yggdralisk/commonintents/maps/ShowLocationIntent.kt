package com.yggdralisk.commonintents.maps

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.yggdralisk.commonintents.utils.ActivityUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class ShowLocationIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_VIEW

        fun create(geoLocation: Uri): Intent =
                Intent(INTENT_ACTION).setData(geoLocation)

        fun resolveActivity(pm: PackageManager, geoLocation: Uri): Boolean =
                ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION).setData(geoLocation))
    }
}