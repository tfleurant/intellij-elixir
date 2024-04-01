package org.elixir_lang.liveview.parser

import com.intellij.html.embedding.HtmlCustomEmbeddedContentTokenType
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.PsiBuilder
import com.intellij.lexer.Lexer
import com.intellij.psi.PsiElement

class LiveviewTemplateExprTokenType(debugName: String, language: Language?) :
    HtmlCustomEmbeddedContentTokenType(debugName, language) {
    override fun createLexer(): Lexer {
        TODO("Not yet implemented")
    }

    override fun createPsi(node: ASTNode): PsiElement {
        TODO("Not yet implemented")
    }

    override fun parse(builder: PsiBuilder) {
        TODO("Not yet implemented")
    }

    enum class ExpressionType {
        BINDING {
            override fun parse(builder: PsiBuilder, tokenType: LiveviewTemplateExprTokenType, name: String?, index: Int) {
                TODO("Not yet implemented")
            }
        },
        INTERPOLATION {
            override fun parse(builder: PsiBuilder, tokenType: LiveviewTemplateExprTokenType, name: String?, index: Int) {
                TODO("Not yet implemented")
            }
        };
//        EVENT {
//            override fun parse(builder: PsiBuilder, tokenType: LiveviewTemplateExprTokenType, name: String?, index: Int) {
//                TODO("Not yet implemented")
//            }
//        };

        abstract fun parse(builder: PsiBuilder, tokenType: LiveviewTemplateExprTokenType, name: String?, index: Int)
    }
}