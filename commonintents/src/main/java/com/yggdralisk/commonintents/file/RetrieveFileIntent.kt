package com.yggdralisk.commonintents.file

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.support.annotation.RequiresApi
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.maybeAddCategory

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class RetrieveFileIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_GET_CONTENT

        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
        fun create(mimeType: String, allowMultiple: Boolean = false, localOnly: Boolean = true, onlyOpenable: Boolean = false): Intent =
                Intent(INTENT_ACTION).setType(mimeType)
                        .putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple)
                        .putExtra(Intent.EXTRA_LOCAL_ONLY, localOnly)
                        .maybeAddCategory(Intent.CATEGORY_OPENABLE, onlyOpenable)

        fun create(mimeType: String, localOnly: Boolean = true): Intent =
                Intent(INTENT_ACTION).setType(mimeType)
                        .putExtra(Intent.EXTRA_LOCAL_ONLY, localOnly)

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION))
    }
}