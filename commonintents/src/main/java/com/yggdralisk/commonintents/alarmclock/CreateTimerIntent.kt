package com.yggdralisk.commonintents.alarmclock

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.AlarmClock
import android.support.annotation.RequiresApi
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.PermissionsUtils

/**
 * Created by Jan Stoltman on 6/9/18.
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
class CreateTimerIntent {
    companion object {
        fun create(message: String = "", length: Int, skipUI: Boolean = false): Intent =
                Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                        .putExtra(AlarmClock.EXTRA_LENGTH, length)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, skipUI)


        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(AlarmClock.ACTION_SET_ALARM))

        fun checkPermissions(context: Context): Boolean = PermissionsUtils.checkPermissions(context, Manifest.permission.SET_ALARM)

        fun requestPermissions(activity: Activity, requestCode: Int) = PermissionsUtils.requestPermissions(activity,
                arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION), requestCode)
    }
}