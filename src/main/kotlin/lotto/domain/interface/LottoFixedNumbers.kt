package lotto.domain.`interface`

import lotto.domain.LottoNumber

class LottoFixedNumbers : LottoNumbers {
    override fun createNumbers(inputs: List<Int>?): Set<LottoNumber> {
        require(inputs != null)

        val lottoNumbers = mutableSetOf<LottoNumber>()
        for (input in inputs.toSortedSet()) {
            lottoNumbers.add(LottoNumber.of(input))
        }

        return lottoNumbers
    }
}
