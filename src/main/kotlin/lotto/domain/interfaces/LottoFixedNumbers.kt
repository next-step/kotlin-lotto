package lotto.domain.interfaces

import lotto.domain.LottoNumber

class LottoFixedNumbers() : LottoNumbers {
    override fun convertLottoNumbers(inputs: List<Int>): Set<LottoNumber> {
        val lottoNumbers = mutableSetOf<LottoNumber>()
        for (input in inputs.toSortedSet()) {
            lottoNumbers.add(LottoNumber.of(input))
        }

        return lottoNumbers
    }

    companion object {
        private val instance = LottoFixedNumbers()

        fun getInstance(): LottoFixedNumbers {
            return instance
        }
    }
}
