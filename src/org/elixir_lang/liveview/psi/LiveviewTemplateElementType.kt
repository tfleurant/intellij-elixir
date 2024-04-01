package org.elixir_lang.liveview.psi

import com.intellij.psi.tree.IElementType
import org.elixir_lang.liveview.LiveviewTemplateLanguage

class LiveviewTemplateElementType(debugName: String) :
    IElementType(debugName, LiveviewTemplateLanguage.INSTANCE)