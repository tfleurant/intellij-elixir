package org.elixir_lang.liveview.psi

import com.intellij.psi.tree.IElementType
import org.elixir_lang.liveview.LiveviewTemplateLanguage

class LiveviewTemplateTokenType(debugName: String) : IElementType(debugName, LiveviewTemplateLanguage.INSTANCE){
    override fun toString(): String {
        return "LiveviewTemplateTokenType." + super.toString()
    }
}