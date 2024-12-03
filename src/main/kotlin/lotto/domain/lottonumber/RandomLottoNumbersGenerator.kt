package lotto.domain.lottonumber

import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBER_RANGE
import lotto.domain.LottoNumbers.Companion.START_INDEX

class RandomLottoNumbersGenerator : LottoNumbersGenerator {
    override fun generate(): LottoNumbers = LottoNumbers(LOTTO_NUMBER_RANGE.shuffled().subList(START_INDEX, LOTTO_NUMBER_COUNT).sorted())
}
