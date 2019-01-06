package ch.tutteli.atrium.creating

import ch.tutteli.atrium.assertions.Assertion

/**
 * Represents an [AssertionPlant] which is intended to serve as receiver object for lambdas which create
 * [Assertion]s, in which this assertion plant collects the so created assertions.
 *
 * In contrast to [ReportingAssertionPlant], this plant does not offer error reporting capabilities and in contrast to
 * [CheckingAssertionPlant] it does not offer checking capabilities either.
 * It merely offers a method to [getAssertions] (the collected ones).
 *
 * @param T The type of the [subject] of this [AssertionPlant].
 */
interface CollectingAssertionPlant<out T : Any> : AssertionPlant<T>,
    BaseCollectingAssertionPlant<T, AssertionPlant<T>, CollectingAssertionPlant<T>> {

    override fun addAssertionsCreatedBy(assertionCreator: AssertionPlant<T>.() -> Unit): CollectingAssertionPlant<T>
}
