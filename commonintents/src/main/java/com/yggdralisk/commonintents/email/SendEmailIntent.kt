package com.yggdralisk.commonintents.email

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.yggdralisk.commonintents.utils.ActivityUtils

/**
 * Created by Jan Stoltman on 6/10/18.
 */
class SendEmailIntent {
    companion object {
        private val MAILTO_URI: Uri = Uri.parse("mailto:")

        fun create(subject: String, emailBody: String,
                   actionType: ActionType = ActionType.NO_ATTACHMENT, mimeType: MimeType = MimeType.TEXT_PLAIN,
                   addresses: Array<String>? = null, cc: Array<String>? = null, bcc: Array<String>? = null,
                   attachments: ArrayList<Uri>? = null, onlyEmailApps: Boolean = false): Intent {
            val intent = Intent(actionType.type).setType(mimeType.type)

            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, emailBody)

            addresses?.let { intent.putExtra(Intent.EXTRA_EMAIL, addresses) }
            cc?.let { intent.putExtra(Intent.EXTRA_CC, cc) }
            bcc?.let { intent.putExtra(Intent.EXTRA_BCC, cc) }

            if (attachments != null && attachments.isNotEmpty()) {
                if (actionType == ActionType.MULTIPLE_ATTACHMENTS) {
                    intent.putExtra(Intent.EXTRA_STREAM, attachments)
                } else {
                    intent.putExtra(Intent.EXTRA_STREAM, attachments.first())
                }
            }

            if (onlyEmailApps){intent.setData(MAILTO_URI)}

            return intent
        }

        fun resolveActivity(pm: PackageManager): Boolean = ActivityUtils.resolveActivity(pm, Intent(ActionType.NO_ATTACHMENT.type).setType(MimeType.TEXT_PLAIN.type))
    }

    enum class ActionType(val type: String) {
        NO_ATTACHMENT(Intent.ACTION_SENDTO),
        ONE_ATTACHMENT(Intent.ACTION_SEND),
        MULTIPLE_ATTACHMENTS(Intent.ACTION_SEND_MULTIPLE)
    }

    enum class MimeType(val type: String) {
        TEXT_PLAIN("text/plain"),
        ANY("*/*")
    }
}