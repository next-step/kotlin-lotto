package lotto

import org.assertj.core.api.ObjectAssert

inline fun <reified T> ObjectAssert<*>.isA(): ObjectAssert<*> = isInstanceOf(T::class.java)
