package com.yggdralisk.commonintents.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

/**
 * Created by Jan Stoltman on 6/10/18.
 */
internal class PermissionsUtils {
    companion object {
        fun checkPermissions(context: Context, permission: String): Boolean =
                ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_DENIED

        fun requestPermissions(activity: Activity, permissions: Array<String>, requestCode: Int) =
                ActivityCompat.requestPermissions(activity, permissions, requestCode);
    }
}
