package lotto.dto

import lotto.dto.LottoNumbers.Companion.LOTTO_NUMBER_COUNT
import lotto.dto.LottoNumbers.Companion.LOTTO_NUMBER_RANGE

object LottoNumberGenerator {

    private val LOTTO_NUMBER_SEED = LOTTO_NUMBER_RANGE.toList()

    fun generate(): LottoNumbers = LottoNumbers(
        LOTTO_NUMBER_SEED.shuffled().subList(0, LOTTO_NUMBER_COUNT)
    )
}
