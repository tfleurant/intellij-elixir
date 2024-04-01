package org.elixir_lang.liveview.lexer

import com.intellij.psi.tree.IElementType
import org.elixir_lang.liveview.LiveviewTemplateLanguage
import org.jetbrains.annotations.NonNls

class LiveviewTemplateTokenType(debugName: @NonNls String) :
    IElementType(debugName, LiveviewTemplateLanguage.INSTANCE)