package lotto.domain

import lotto.domain.LottoNumber.Companion.from

fun createSimpleLottoNumbers(vararg numbers: Int): LottoNumbers {
    if (numbers.isEmpty()) {
        return LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
    }
    return LottoNumbers(numbers.map { from(it) }.toSet())
}

fun createSimpleLotto(vararg numbers: Int): Lotto {
    return Lotto(createSimpleLottoNumbers(*numbers))
}

fun createSimpleLotto(numbers: Set<Int>): Lotto {
    return Lotto(createSimpleLottoNumbers(*numbers.toIntArray()))
}
