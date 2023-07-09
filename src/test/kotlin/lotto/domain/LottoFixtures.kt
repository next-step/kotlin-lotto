package lotto.domain

import lotto.domain.LottoNumber.Companion.from

fun createSimpleLottoNumbers(vararg numbers: Int): Lotto {
    if (numbers.isEmpty()) {
        return Lotto(listOf(1, 2, 3, 4, 5, 6))
    }
    return Lotto(numbers.map { from(it) }.toSet())
}

fun createSimpleLottoNumbers(numbers: Set<Int>): Lotto {
    return createSimpleLottoNumbers(*numbers.toIntArray())
}
