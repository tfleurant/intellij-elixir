package org.elixir_lang.liveview.file

import com.intellij.lang.Language
import com.intellij.lang.html.HTMLLanguage
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.LanguageSubstitutors
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider
import com.intellij.psi.PsiManager
import com.intellij.psi.templateLanguages.ConfigurableTemplateLanguageFileViewProvider
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings
import org.elixir_lang.ElixirLanguage
import org.elixir_lang.eex.file.Type.Companion.onlyTemplateDataFileType

class LiveviewTemplateFileViewProvider(
    manager: PsiManager,
    file: VirtualFile,
    physical: Boolean,
    private val baseLanguage: Language,
    private val templateLanguage: Language
) : MultiplePsiFilesPerDocumentFileViewProvider(manager, file, physical),
    ConfigurableTemplateLanguageFileViewProvider {


    override fun getBaseLanguage(): Language {
        return baseLanguage
    }

    override fun getLanguages(): MutableSet<Language> {
        return listOf(templateLanguage, baseLanguage, HTMLLanguage.INSTANCE, ElixirLanguage).toMutableSet()
    }

    override fun getTemplateDataLanguage(): Language {
        return templateLanguage
    }

    override fun cloneInner(fileCopy: VirtualFile): MultiplePsiFilesPerDocumentFileViewProvider {
        return LiveviewTemplateFileViewProvider(
            manager,
            fileCopy,
            false,
            baseLanguage,
            templateDataLanguage
        )

    }

    // TODO might need some fixing
    override fun supportsIncrementalReparse(rootLanguage: Language): Boolean {
        return false
    }

    companion object {
        fun create(
            manager: PsiManager,
            file: VirtualFile,
            physical: Boolean,
            baseLanguage: Language
        ): LiveviewTemplateFileViewProvider {
            return LiveviewTemplateFileViewProvider(
                manager,
                file,
                physical,
                baseLanguage,
                templateDataLanguage(manager, file)
            )
        }

        private fun templateDataLanguage(
            psiManager: PsiManager,
            virtualFile: VirtualFile
        ): Language {
            val project = psiManager.project
            var templateDataLanguage =
                TemplateDataLanguageMappings.getInstance(project).getMapping(virtualFile)

            if (templateDataLanguage == null) {
                templateDataLanguage = onlyTemplateDataFileType(virtualFile)
                    .filter(LanguageFileType::class.java::isInstance)
                    .map(LanguageFileType::class.java::cast)
                    .map { it.language }
                    .orElse(null)
            }

            if (templateDataLanguage == null) { // FIXME
                templateDataLanguage =
                    org.elixir_lang.eex.Language.defaultTemplateLanguageFileType().language
            }

            val substituteLang =
                LanguageSubstitutors.getInstance()
                    .substituteLanguage(templateDataLanguage, virtualFile, project)

            // only use a substituted language if it's templateable
            if (TemplateDataLanguageMappings.getTemplateableLanguages().contains(substituteLang)) {
                templateDataLanguage = substituteLang
            }

            return templateDataLanguage
        }
    }
}