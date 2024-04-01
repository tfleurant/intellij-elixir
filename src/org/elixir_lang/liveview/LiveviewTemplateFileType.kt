package org.elixir_lang.liveview

import com.intellij.openapi.fileTypes.LanguageFileType
import org.elixir_lang.Icons
import javax.swing.Icon

class LiveviewTemplateFileType : LanguageFileType(LiveviewTemplateLanguage.INSTANCE) {
    override fun getName(): String {
        return "Liveview template file"
    }

    override fun getDescription(): String {
        return "Liveview html template file"
    }

    override fun getDefaultExtension(): String {
        return "heex" // FIXME can we specify to html ? Do we really need to ?
    }

    override fun getIcon(): Icon {
        return Icons.FILE // FIXME use custom html/phoenix icon
    }

    companion object {
        @JvmField
        val INSTANCE = LiveviewTemplateFileType()
    }
}