package lotto.domain.lottonumber

import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBER_COUNT

class RandomLottoNumbersGenerator : LottoNumbersGenerator {
    override fun generate(): LottoNumbers =
        LottoNumbers.from(LOTTO_NUMBER_RANGE.shuffled().subList(START_INDEX, LOTTO_NUMBER_COUNT).sorted())

    companion object {
        const val START_INDEX = 0
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
