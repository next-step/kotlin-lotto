package lotto.util

import java.lang.Integer.min

fun <T> Collection<T>.shuffleAndSelect(count: Int) = this.shuffled().subList(0, min(this.count(), count))
fun <T> Iterable<T>.shuffleAndSelect(count: Int) = this.toList().shuffleAndSelect(count)
