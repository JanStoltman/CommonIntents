package com.yggdralisk.commonintents.utils

import android.content.Intent
import android.content.pm.PackageManager

/**
 * Created by Jan Stoltman on 6/10/18.
 */
internal class ActivityUtils {
    companion object {
        // Intent.resolveActivity() will return true even activity is not exported
        // (which makes it unusable for all practical purposes in case it's not from your package)
        fun resolveActivity(pm: PackageManager, intent: Intent): Boolean =
                intent.resolveActivity(pm) != null && intent.resolveActivityInfo(pm, intent.flags).exported
    }
}
