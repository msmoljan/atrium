package ch.tutteli.atrium.reporting

import ch.tutteli.atrium.core.polyfills.getAtriumProperty
import ch.tutteli.atrium.core.polyfills.loadServices
import ch.tutteli.atrium.core.polyfills.setAtriumProperty

/**
 * The access point to an implementation of [Reporter].
 *
 * It loads implementations of [ReporterFactory] lazily via [loadServices] and searches for the id specified via
 * Atrium's property with key [ReporterFactory.ATRIUM_PROPERTY_KEY] (which is
 * `ch.tutteli.atrium.reporting.reporterFactory`) or uses `default` in case the property is not specified.
 *
 * Use [ReporterFactory.specifyFactory] or [ReporterFactory.specifyFactoryIfNotYetSet] to define another value for the
 * property.
 *
 * Notice, that searching for a [ReporterFactory] is only done once and the result is cached afterwards.
 * Please [open an issue](https://github.com/robstoll/atrium/issues/new?template=feature_request.md&title=[Feature]%20change%20Reporter%20during%20test%20run)
 * if you want to able to change the [Reporter] during a test-run.
 */
val reporter: Reporter by lazy {
    val id = getAtriumProperty(ReporterFactory.ATRIUM_PROPERTY_KEY) ?: "default"
    val factory = loadServices(ReporterFactory::class)
        .firstOrNull { it.id == id }
        ?: throw IllegalStateException("Could not find a ${ReporterFactory::class.simpleName} with id $id")

    factory.create()
}


/**
 * Responsible to create a [Reporter].
 *
 * It identify itself via its [id]. This id can be used by a user to specify that this [ReporterFactory] shall be used.
 * In order to do that, the user has to define the system property `ch.tutteli.atrium.reporting.reporterFactory`
 */
interface ReporterFactory {
    /**
     * Identification of the supplier
     */
    val id: String

    /**
     * Creates a new [Reporter].
     */
    fun create(): Reporter

    /**
     * Provides utility functions to specify a [ReporterFactory].
     */
    companion object {
        /**
         * The key of Atrium's property which is used to define which [ReporterFactory] shall be used.
         * You can use [ReporterFactory.specifyFactory] or [ReporterFactory.specifyFactoryIfNotYetSet]
         */
        const val ATRIUM_PROPERTY_KEY = "ch.tutteli.atrium.reporting.reporterFactory"

        /**
         * Sets Atrium's property with key [ATRIUM_PROPERTY_KEY] (which is
         * `ch.tutteli.atrium.reporting.reporterFactory`) to the given [reporterFactoryId]
         * regardless if another id was specified before.
         *
         * Use [specifyFactoryIfNotYetSet] if you only want to set a default value but not overwrite an existing
         * specification.
         */
        fun specifyFactory(reporterFactoryId: String) {
            setAtriumProperty(ATRIUM_PROPERTY_KEY, reporterFactoryId)
        }

        /**
         * Sets Atrium's property with key [ATRIUM_PROPERTY_KEY] (which is
         * `ch.tutteli.atrium.reporting.reporterFactory`) to the given [reporterFactoryId]
         * if another id was not *yet* specified before.
         *
         * Use [specifyFactory] if you do not care if another id was specified before or in other words, if you want to
         * overwrite a potentially previously defined id.
         */
        fun specifyFactoryIfNotYetSet(reporterFactoryId: String) {
            if (getAtriumProperty(ATRIUM_PROPERTY_KEY) == null) {
                specifyFactory(reporterFactoryId)
            }
        }
    }
}
