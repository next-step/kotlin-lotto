package lotto.domain.interfaces

import lotto.domain.LottoNumber
import lotto.domain.interfaces.LottoNumbers.Companion.MAX_LOTTO_INDEX
import lotto.domain.interfaces.LottoNumbers.Companion.MIN_LOTTO_INDEX

class LottoRandomNumbers private constructor() : LottoNumbers {
    private val randomNumbers
        get() = LottoNumber
            .LOTTO_NUMBER_RANGE
            .toMutableList()
            .shuffled()
            .subList(MIN_LOTTO_INDEX, MAX_LOTTO_INDEX)
            .sorted()

    override fun createNumbers(): Set<LottoNumber> {
        val lottoNumbers = mutableSetOf<LottoNumber>()
        for (number in randomNumbers) {
            lottoNumbers.add(LottoNumber.of(number))
        }

        return lottoNumbers
    }

    companion object {
        private val instance = LottoRandomNumbers()

        fun getInstance(): LottoRandomNumbers {
            return instance
        }
    }
}
