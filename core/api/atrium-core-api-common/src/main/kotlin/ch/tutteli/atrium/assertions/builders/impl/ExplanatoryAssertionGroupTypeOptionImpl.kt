package ch.tutteli.atrium.assertions.builders.impl

import ch.tutteli.atrium.assertions.Assertion
import ch.tutteli.atrium.assertions.DefaultExplanatoryAssertionGroupType
import ch.tutteli.atrium.assertions.ExplanatoryAssertionGroupType
import ch.tutteli.atrium.assertions.WarningAssertionGroupType
import ch.tutteli.atrium.assertions.builders.AssertionsOption
import ch.tutteli.atrium.assertions.builders.ExplanatoryAssertionGroupFinalStep
import ch.tutteli.atrium.assertions.builders.ExplanatoryAssertionGroupTypeOption
import ch.tutteli.atrium.reporting.translating.Translatable

internal object ExplanatoryAssertionGroupTypeOptionImpl : ExplanatoryAssertionGroupTypeOption {

    override val withDefaultType: AssertionsOption<DefaultExplanatoryAssertionGroupType, ExplanatoryAssertionGroupFinalStep>
        = createAssertionsOption(DefaultExplanatoryAssertionGroupType)

    override val withWarningType: AssertionsOption<WarningAssertionGroupType, ExplanatoryAssertionGroupFinalStep>
        = createAssertionsOption(WarningAssertionGroupType)

    override fun <T : ExplanatoryAssertionGroupType> withType(
        groupType: T
    ): AssertionsOption<T, ExplanatoryAssertionGroupFinalStep> = createAssertionsOption(groupType)

    private fun <T : ExplanatoryAssertionGroupType> createAssertionsOption(groupType: T)
        = AssertionsOption.withEmptyDescriptionAndRepresentation(
            groupType, ::createExplanatoryAssertionGroupFinalStep
        )

    @Suppress("UNUSED_PARAMETER")
    private fun <T : ExplanatoryAssertionGroupType> createExplanatoryAssertionGroupFinalStep(
        groupType: T,
        ignoredDescription: Translatable,
        ignoredRepresentation: Any,
        explanatoryAssertions: List<Assertion>
    ): ExplanatoryAssertionGroupFinalStep = ExplanatoryAssertionGroupFinalStep.create(groupType, explanatoryAssertions)
}
