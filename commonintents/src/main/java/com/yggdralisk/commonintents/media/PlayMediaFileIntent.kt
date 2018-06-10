package com.yggdralisk.commonintents.media

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.yggdralisk.commonintents.utils.ActivityUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class PlayMediaFileIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_VIEW

        fun create(file: Uri, mimeType: String): Intent =
                Intent(INTENT_ACTION).setType(mimeType).setData(file)

        fun resolveActivity(pm: PackageManager, file: Uri, mimeType: String): Boolean =
                ActivityUtils.resolveActivity(pm, create(file, mimeType))
    }
}