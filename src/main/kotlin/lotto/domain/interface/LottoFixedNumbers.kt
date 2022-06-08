package lotto.domain.`interface`

import lotto.domain.LottoNumber

class LottoFixedNumbers(private val inputs: List<Int>) : LottoNumbers {
    override fun createNumbers(): Set<LottoNumber> {
        require(inputs != null)
        val lottoNumbers = mutableSetOf<LottoNumber>()
        for (input in inputs.toSortedSet()) {
            lottoNumbers.add(LottoNumber.of(input))
        }

        return lottoNumbers
    }
}
