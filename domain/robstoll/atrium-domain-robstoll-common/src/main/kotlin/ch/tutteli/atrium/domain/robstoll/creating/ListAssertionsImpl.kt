package ch.tutteli.atrium.domain.robstoll.creating

import ch.tutteli.atrium.creating.AssertionPlant
import ch.tutteli.atrium.creating.AssertionPlantNullable
import ch.tutteli.atrium.domain.creating.ListAssertions
import ch.tutteli.atrium.domain.robstoll.lib.creating._get
import ch.tutteli.atrium.domain.robstoll.lib.creating._getNullable

/**
 * Robstoll's implementation of [ListAssertions].
 */
class ListAssertionsImpl : ListAssertions {

    override fun <T : Any> get(
        plant: AssertionPlant<List<T>>,
        index: Int,
        assertionCreator: AssertionPlant<T>.() -> Unit
    ) = _get(plant, index, assertionCreator)

    override fun <T> getNullable(
        plant: AssertionPlant<List<T>>,
        index: Int,
        assertionCreator: AssertionPlantNullable<T>.() -> Unit
    ) = _getNullable(plant, index, assertionCreator)

}
