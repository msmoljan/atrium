package ch.tutteli.atrium.domain.robstoll.creating.collectors

import ch.tutteli.atrium.creating.BaseAssertionPlant
import ch.tutteli.atrium.creating.BaseCollectingAssertionPlant
import ch.tutteli.atrium.domain.creating.collectors.AssertionCollector
import ch.tutteli.atrium.domain.robstoll.lib.creating.collectors._collectAssertions
import ch.tutteli.atrium.domain.robstoll.lib.creating.collectors._collectOrExplain
import ch.tutteli.atrium.reporting.translating.Translatable

class AssertionCollectorImpl : AssertionCollector {

    override fun <T, A : BaseAssertionPlant<T, A>, C : BaseCollectingAssertionPlant<T, A, C>> collect(
        subjectProvider: () -> T,
        collectingPlantFactory: (() -> T) -> C,
        assertionCreator: C.() -> Unit
    ) = _collectAssertions(subjectProvider, collectingPlantFactory, assertionCreator)

    override fun <T, A : BaseAssertionPlant<T, A>, C : BaseCollectingAssertionPlant<T, A, C>> collectOrExplain(
        safeToCollect: Boolean,
        warningCannotEvaluate: Translatable,
        subjectProvider: () -> T,
        collectingPlantFactory: (() -> T) -> C,
        assertionCreator: C.() -> Unit
    ) = _collectOrExplain(
        safeToCollect, warningCannotEvaluate, subjectProvider, collectingPlantFactory, assertionCreator
    )
}
