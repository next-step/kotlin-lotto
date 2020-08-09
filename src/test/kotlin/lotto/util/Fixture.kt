@file:JvmName("Fixture")

package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Rank

fun createLottoNumber(value: Int): LottoNumber {
    return LottoNumber(value)
}

fun createLottoNumbers(numbers: List<Int>): List<LottoNumber> {
    return numbers.map { createLottoNumber(it) }
}

fun createLotto(lottoNumbers: List<LottoNumber>): Lotto {
    return Lotto(lottoNumbers)
}

fun createResult(): MutableMap<Rank, Int> {
    return mutableMapOf(
        Rank.FIFTH to 0,
        Rank.FOURTH to 0,
        Rank.THIRD to 0,
        Rank.SECOND to 0,
        Rank.FIRST to 0
    )
}
