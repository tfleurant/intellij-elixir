package org.elixir_lang.liveview

import com.intellij.lang.Language
import com.intellij.psi.templateLanguages.TemplateLanguage

class LiveviewTemplateLanguage: Language("LiveviewTemplate"), TemplateLanguage {
    companion object {
        val INSTANCE: LiveviewTemplateLanguage = LiveviewTemplateLanguage()
    }
}