package com.yggdralisk.commonintents.messages

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.yggdralisk.commonintents.utils.ActivityUtils
import com.yggdralisk.commonintents.utils.maybePutArrayListExtra
import com.yggdralisk.commonintents.utils.maybePutStringExtra

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class ComposeMessageIntent {
    companion object {
        fun create(action: ActionType, mimeType: MimeType, dataScheme: Uri,
                   subject: String? = null, message: String? = null, attachments: ArrayList<Uri> = arrayListOf()): Intent =
                Intent(action.type)
                        .setData(dataScheme)
                        .setType(mimeType.type)
                        .maybePutStringExtra("subject", subject)
                        .maybePutStringExtra("sms_body", message)
                        .maybePutArrayListExtra(Intent.EXTRA_STREAM, attachments, action.type)


        fun resolveActivity(pm: PackageManager, action: ActionType, mimeType: MimeType, dataScheme: Uri): Boolean =
                ActivityUtils.resolveActivity(pm, create(action = action,
                        mimeType = mimeType,
                        dataScheme = dataScheme))
    }

    enum class ActionType(val type: String) {
        NO_ATTACHMENT(Intent.ACTION_SENDTO),
        ONE_ATTACHMENT(Intent.ACTION_SEND),
        MULTIPLE_ATTACHMENTS(Intent.ACTION_SEND_MULTIPLE)
    }

    enum class MimeType(val type: String) {
        TEXT_PLAIN("text/plain"),
        IMAGE("image/*"),
        VIDEO("video/*")
    }
}