package com.yggdralisk.commonintents.camera

import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import com.yggdralisk.commonintents.utils.ActivityUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class CameraInVideoModeIntent{
    companion object {
        private const val INTENT_ACTION = MediaStore.INTENT_ACTION_VIDEO_CAMERA

        fun create(): Intent = Intent(INTENT_ACTION)

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}