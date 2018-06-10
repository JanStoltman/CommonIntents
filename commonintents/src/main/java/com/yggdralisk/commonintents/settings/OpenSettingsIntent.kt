package com.yggdralisk.commonintents.settings

import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import com.yggdralisk.commonintents.utils.ActivityUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class OpenSettingsIntent {
    companion object {
        fun create(settingsAction: String): Intent =
                Intent(settingsAction)

        fun resolveActivity(pm: PackageManager, settingsAction: String = Settings.ACTION_SETTINGS): Boolean =
                ActivityUtils.resolveActivity(pm, Intent(settingsAction))
    }
}