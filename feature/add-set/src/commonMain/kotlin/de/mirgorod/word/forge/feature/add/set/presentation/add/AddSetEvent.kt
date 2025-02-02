package de.mirgorod.word.forge.feature.add.set.presentation.add

internal sealed class AddSetEvent {
    class AddSet : AddSetEvent()
    class AddWord : AddSetEvent()
    data class ChangeNameSet(val name: String) : AddSetEvent()
    data class ChangeWordById(val id: Int, val newValue: String) : AddSetEvent()
    data class ChangeTranslationById(val id: Int, val newValue: String) : AddSetEvent()
}