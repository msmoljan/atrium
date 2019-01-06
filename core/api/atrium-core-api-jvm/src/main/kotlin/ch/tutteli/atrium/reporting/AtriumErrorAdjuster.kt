package ch.tutteli.atrium.reporting

/**
 * Responsible to adjust a given [AtriumError] for improved error reporting.
 *
 * Typically this involves filtering the [AtriumError.stackTrace] in some way or another.
 */
actual interface AtriumErrorAdjuster : AtriumErrorAdjusterCommon {

    /**
     * Adjusts the [AtriumError.stackTrace] in some way or another.
     *
     * @return The adjusted stack.
     */
    fun adjustStackTrace(stackTrace: Sequence<StackTraceElement>): Sequence<StackTraceElement>
}
