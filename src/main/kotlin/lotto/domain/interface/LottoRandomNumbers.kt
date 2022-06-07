package lotto.domain.`interface`

import lotto.domain.LottoNumber
import lotto.domain.`interface`.LottoNumbers.Companion.MAX_LOTTO_INDEX
import lotto.domain.`interface`.LottoNumbers.Companion.MIN_LOTTO_INDEX

class LottoRandomNumbers : LottoNumbers {
    private val randomNumbers = LottoNumber.LOTTO_NUMBER_RANGE
        .toMutableList()
        .shuffled()
        .subList(MIN_LOTTO_INDEX, MAX_LOTTO_INDEX)
        .sorted()

    override fun createNumbers(inputs: List<Int>?): Set<LottoNumber> {
        val lottoNumbers = mutableSetOf<LottoNumber>()

        for (index in randomNumbers.indices) {
            lottoNumbers.add(LottoNumber.of(randomNumbers[index]))
        }

        return lottoNumbers
    }
}
