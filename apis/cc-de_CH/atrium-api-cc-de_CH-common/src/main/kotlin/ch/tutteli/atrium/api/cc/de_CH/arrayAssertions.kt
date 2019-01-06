package ch.tutteli.atrium.api.cc.de_CH

import ch.tutteli.atrium.core.polyfills.JvmName
import ch.tutteli.atrium.creating.Assert
import ch.tutteli.atrium.creating.AssertionPlant
import ch.tutteli.atrium.domain.builders.AssertImpl

/**
 * Turns `Assert<Array<E>>` into `Assert<Iterable<E>>`.
 *
 * The transformation as such is not reflected in reporting.
 * Use `returnValueOf(Array<out E>::asIterable)` if you want to show the transformation in reporting.
 *
 * @return The newly created [AssertionPlant] for the transformed subject.
 */
fun <E> Assert<Array<out E>>.asIterable(): Assert<Iterable<E>>
    = AssertImpl.changeSubject(this) { subject.asIterable() }

/**
 * Turns `Assert<CharArray>` into `Assert<Iterable<Byte>>`.
 *
 * The transformation as such is not reflected in reporting.
 * Use `returnValueOf(ByteArray::asIterable)` if you want to show the transformation in reporting.
 *
 * @return The newly created [AssertionPlant] for the transformed subject.
 */
@JvmName("byteArrAsIterable")
fun Assert<ByteArray>.asIterable(): Assert<Iterable<Byte>>
    = AssertImpl.changeSubject(this) { subject.asIterable() }

/**
 * Turns `Assert<CharArray>` into `Assert<Iterable<Char>>`.
 *
 * The transformation as such is not reflected in reporting.
 * Use `returnValueOf(CharArray::asIterable)` if you want to show the transformation in reporting.
 *
 * @return The newly created [AssertionPlant] for the transformed subject.
 */
@JvmName("charArrAsIterable")
fun Assert<CharArray>.asIterable(): Assert<Iterable<Char>>
    = AssertImpl.changeSubject(this) { subject.asIterable() }

/**
 * Turns `Assert<ShortArray>` into `Assert<Iterable<Short>>`.
 *
 * The transformation as such is not reflected in reporting.
 * Use `returnValueOf(ShortArray::asIterable)` if you want to show the transformation in reporting.
 *
 * @return The newly created [AssertionPlant] for the transformed subject.
 */
@JvmName("shortArrAsIterable")
fun Assert<ShortArray>.asIterable(): Assert<Iterable<Short>>
    = AssertImpl.changeSubject(this) { subject.asIterable() }

/**
 * Turns `Assert<IntArray>` into `Assert<Iterable<Int>>`.
 *
 * The transformation as such is not reflected in reporting.
 * Use `returnValueOf(IntArray::asIterable)` if you want to show the transformation in reporting.
 *
 * @return The newly created [AssertionPlant] for the transformed subject.
 */
@JvmName("intArrAsIterable")
fun Assert<IntArray>.asIterable(): Assert<Iterable<Int>>
    = AssertImpl.changeSubject(this) { subject.asIterable() }

/**
 * Turns `Assert<LongArray>` into `Assert<Iterable<Double>>`.
 *
 * The transformation as such is not reflected in reporting.
 * Use `returnValueOf(LongArray::asIterable)` if you want to show the transformation in reporting.
 *
 * @return The newly created [AssertionPlant] for the transformed subject.
 */
@JvmName("longArrAsIterable")
fun Assert<LongArray>.asIterable(): Assert<Iterable<Long>>
    = AssertImpl.changeSubject(this) { subject.asIterable() }
/**
 * Turns `Assert<FloatArray>` into `Assert<Iterable<Float>>`.
 *
 * The transformation as such is not reflected in reporting.
 * Use `returnValueOf(FloatArray::asIterable)` if you want to show the transformation in reporting.
 *
 * @return The newly created [AssertionPlant] for the transformed subject.
 */
@JvmName("floatArrAsIterable")
fun Assert<FloatArray>.asIterable(): Assert<Iterable<Float>>
    = AssertImpl.changeSubject(this) { subject.asIterable() }

/**
 * Turns `Assert<DoubleArray>` into `Assert<Iterable<Double>>`.
 *
 * The transformation as such is not reflected in reporting.
 * Use `returnValueOf(DoubleArray::asIterable)` if you want to show the transformation in reporting.
 *
 * @return The newly created [AssertionPlant] for the transformed subject.
 */
@JvmName("doubleArrAsIterable")
fun Assert<DoubleArray>.asIterable(): Assert<Iterable<Double>>
    = AssertImpl.changeSubject(this) { subject.asIterable() }

/**
 * Turns `Assert<BooleanArray>` into `Assert<Iterable<Boolean>>`.
 *
 * The transformation as such is not reflected in reporting.
 * Use `returnValueOf(BooleanArray::asIterable)` if you want to show the transformation in reporting.
 *
 * @return The newly created [AssertionPlant] for the transformed subject.
 */
@JvmName("boolArrAsIterable")
fun Assert<BooleanArray>.asIterable(): Assert<Iterable<Boolean>>
    = AssertImpl.changeSubject(this) { subject.asIterable() }
