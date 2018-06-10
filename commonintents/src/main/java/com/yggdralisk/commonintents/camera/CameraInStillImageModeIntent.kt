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
class CameraInStillImageModeIntent {
    companion object {
        private const val INTENT_ACTION = MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA

        fun create(): Intent = Intent(INTENT_ACTION)

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}