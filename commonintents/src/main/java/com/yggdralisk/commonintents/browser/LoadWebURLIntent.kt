package com.yggdralisk.commonintents.browser

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.yggdralisk.commonintents.utils.ActivityUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class LoadWebURLIntent {
    companion object {
        private const val INTENT_ACTION = Intent.ACTION_VIEW

        fun create(url: Uri, mimeType: MimeType): Intent =
                Intent(INTENT_ACTION, url)
                        .setType(mimeType.type)

        fun resolveActivity(pm: PackageManager, mimeType: MimeType): Boolean =
                ActivityUtils.resolveActivity(pm, Intent(INTENT_ACTION).setType(mimeType.type))

        enum class MimeType(val type: String) {
            TEXT_PLAIN("text/plain"),
            TEXT_HTML("text/html"),
            APPLICATION_XTML_XML("application/xhtml+xml"),
            APPLICATION_VND_XTML_XML("application/vnd.wap.xhtml+xml")
        }
    }
}