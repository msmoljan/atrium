package ch.tutteli.atrium.api.cc.de_CH

import ch.tutteli.atrium.api.cc.de_CH.creating.charsequence.contains.builders.AtLeastCheckerOption
import ch.tutteli.atrium.creating.Assert
import ch.tutteli.atrium.domain.creating.charsequence.contains.CharSequenceContains
import ch.tutteli.atrium.domain.creating.charsequence.contains.searchbehaviours.NoOpSearchBehaviour
import kotlin.reflect.KProperty

abstract class CharSequenceContainsSpecBase {
    private val containsProp: KProperty<*> = Assert<String>::enthaelt
    protected val contains = containsProp.name
    private val containsNotProp: KProperty<*> = Assert<String>::enthaeltNicht
    protected val containsNot = containsNotProp.name
    protected val containsRegex = Assert<String>::enthaeltRegex.name
    protected val atLeast = CharSequenceContains.Builder<*, *>::zumindest.name
    protected val butAtMost = AtLeastCheckerOption<*, *>::aberHoechstens.name
    protected val exactly = CharSequenceContains.Builder<*, *>::genau.name
    protected val atMost = CharSequenceContains.Builder<*, *>::hoechstens.name
    protected val notOrAtMost = CharSequenceContains.Builder<*, *>::nichtOderHoechstens.name
    protected val regex = CharSequenceContains.CheckerOption<*, NoOpSearchBehaviour>::regex.name
    protected val defaultTranslationOf = CharSequenceContains.CheckerOption<*, NoOpSearchBehaviour>::standardUebersetzungVon.name
    protected val ignoringCase = CharSequenceContains.Builder<*, NoOpSearchBehaviour>::ignoriereGrossKleinschreibung.name
}
