package com.yggdralisk.commonintents.alarmclock

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.AlarmClock
import android.support.annotation.RequiresApi
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.PermissionsUtils


/**
 * Created by Jan Stoltman on 6/9/18.
 */
class SetAlarmIntent {
    companion object {
        private const val INTENT_ACTION = AlarmClock.ACTION_SET_ALARM

        fun create(message: String = "", hour: Int, minutes: Int, skipUI: Boolean = false): Intent =
                Intent(INTENT_ACTION)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                        .putExtra(AlarmClock.EXTRA_HOUR, hour)
                        .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, skipUI)

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        fun create(message: String = "", hour: Int, minutes: Int, days: ArrayList<Int>? = null,
                   ringtone: Uri? = null, vibrate: Boolean = false, skipUI: Boolean = false): Intent {
            val intent = Intent(INTENT_ACTION)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_HOUR, hour)
                    .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, skipUI)
                    .putExtra(AlarmClock.EXTRA_VIBRATE, vibrate)

            days?.let { intent.putExtra(AlarmClock.EXTRA_DAYS, days) }
            ringtone?.let { intent.putExtra(AlarmClock.EXTRA_RINGTONE, ringtone) }

            return intent
        }

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))

        fun checkPermissions(context: Context): Boolean = PermissionsUtils.checkPermissions(context, Manifest.permission.SET_ALARM)

        fun requestPermissions(activity: Activity, requestCode: Int) = PermissionsUtils.requestPermissions(activity,
                arrayOf(android.Manifest.permission.SET_ALARM),
                requestCode)
    }
}