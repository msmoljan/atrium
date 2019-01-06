package ch.tutteli.atrium.domain.builders

import ch.tutteli.atrium.core.polyfills.registerService

@Suppress("unused" /* here in order that the code is executed when module is loaded */)
private val register = run {

    registerService<ch.tutteli.atrium.reporting.ReporterFactory> { ch.tutteli.atrium.domain.builders.reporting.impl.DefaultReporterFactory() }
}