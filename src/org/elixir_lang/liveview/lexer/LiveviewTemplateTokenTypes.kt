package org.elixir_lang.liveview.lexer

import com.intellij.psi.xml.XmlTokenType

interface LiveviewTemplateTokenTypes: XmlTokenType {
    companion object {
        @JvmField
        val EEX_START = LiveviewTemplateTokenType("HEEX:EEX_START")

        @JvmField
        val EEX_END = LiveviewTemplateTokenType("HEEX:EEX_END")

        @JvmField
        val ELIXIR_BINDING_START = LiveviewTemplateTokenType("HEEX:ELIXIR_BINDING_START")

        @JvmField
        val ELIXIR_BINDING_END = LiveviewTemplateTokenType("HEEX:ELIXIR_BINDING_START")

        @JvmField
        val SPECIAL_ATTRIBUTE_START = LiveviewTemplateTokenType("HEEX:SPECIAL_ATTRIBUTE_START")

        @JvmField
        val SPECIAL_ATTRIBUTE_END = LiveviewTemplateTokenType("HEEX:SPECIAL_ATTRIBUTE_END")
    }
}