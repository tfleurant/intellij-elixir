package org.elixir_lang.liveview.file

import com.intellij.lang.Language
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.FileViewProvider
import com.intellij.psi.FileViewProviderFactory
import com.intellij.psi.PsiManager

class LiveviewTemplateFileViewProviderFactory : FileViewProviderFactory {
    override fun createFileViewProvider(
        file: VirtualFile,
        language: Language?,
        manager: PsiManager,
        eventSystemEnabled: Boolean
    ): FileViewProvider {
        return LiveviewTemplateFileViewProvider.create(
            manager,
            file,
            eventSystemEnabled,
            language!!
        ) // FIXME ?
    }
}