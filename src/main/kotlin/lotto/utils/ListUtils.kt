package lotto.utils

import lotto.model.LottoNumbers

fun shuffleAndTake(list: List<Int>, n: Int, sort: Boolean = false): List<Int> {
    val shuffled = list
        .shuffled()
        .take(n)

    return if (sort) {
        shuffled.sorted()
    } else {
        shuffled
    }
}

fun List<LottoNumbers>.convertToLottoNumberList(): List<List<Int>> {
    return map { it.numbers }
}
