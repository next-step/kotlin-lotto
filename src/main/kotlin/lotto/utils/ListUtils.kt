package lotto.utils

import lotto.model.LottoNumbers

fun <T : Comparable<T>> List<T>.shuffleAndTake(n: Int, sort: Boolean = false): List<T> {
    val shuffled = shuffled().take(n)

    return if (sort) { shuffled.sorted() } else { shuffled }
}

fun List<LottoNumbers>.convertToLottoNumberList(): List<List<Int>> {
    return map { it.numbers }
}
