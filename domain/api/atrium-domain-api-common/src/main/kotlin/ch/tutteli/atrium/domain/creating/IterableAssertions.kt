package ch.tutteli.atrium.domain.creating

import ch.tutteli.atrium.assertions.Assertion
import ch.tutteli.atrium.core.polyfills.loadSingleService
import ch.tutteli.atrium.creating.AssertionPlant
import ch.tutteli.atrium.domain.creating.iterable.contains.IterableContains
import ch.tutteli.atrium.domain.creating.iterable.contains.searchbehaviours.NoOpSearchBehaviour
import ch.tutteli.atrium.domain.creating.iterable.contains.searchbehaviours.NotSearchBehaviour

/**
 * The access point to an implementation of [IterableAssertions].
 *
 * It loads the implementation lazily via [loadSingleService].
 */
val iterableAssertions by lazy { loadSingleService(IterableAssertions::class) }


/**
 * Defines the minimum set of assertion functions and builders applicable to [Iterable],
 * which an implementation of the domain of Atrium has to provide.
 */
interface IterableAssertions {
    fun <E, T : Iterable<E>> containsBuilder(plant: AssertionPlant<T>): IterableContains.Builder<E, T, NoOpSearchBehaviour>
    fun <E, T : Iterable<E>> containsNotBuilder(plant: AssertionPlant<T>): IterableContains.Builder<E, T, NotSearchBehaviour>

    fun <E: Any, T : Iterable<E?>> all(plant: AssertionPlant<T>, assertionCreator: (AssertionPlant<E>.() -> Unit)?): Assertion
}
