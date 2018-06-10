package com.yggdralisk.commonintents.camera

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.PermissionsUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class CaptureImageIntent {
    companion object {
        private const val INTENT_ACTION = MediaStore.ACTION_IMAGE_CAPTURE

        fun create(targetFilepath: Uri? = null): Intent {
            val intent = Intent(INTENT_ACTION)
            targetFilepath?.let { intent.putExtra(MediaStore.EXTRA_OUTPUT, targetFilepath) }

            return intent
        }

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent())

        fun checkPermissions(context: Context): Boolean = PermissionsUtils.checkPermissions(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        fun requestPermissions(activity: Activity, requestCode: Int) = PermissionsUtils.requestPermissions(activity,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                requestCode)
    }
}