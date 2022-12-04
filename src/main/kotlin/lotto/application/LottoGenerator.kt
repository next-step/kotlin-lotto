package lotto.application

import lotto.domain.LottoNumber
import lotto.domain.LottoNumber.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MINIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbers.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH
import lotto.domain.LottoNumbersList

object LottoGenerator {
    private val lottoNumbers = List(MAXIMUM_LOTTO_NUMBER) { LottoNumber(it + MINIMUM_LOTTO_NUMBER) }

    fun generateLottoNumbers(lottoCount: Int): LottoNumbersList {
        val lottoNumbersList = mutableListOf<LottoNumbers>()
        repeat(lottoCount) {
            val lottoNumbers = generate()
            lottoNumbersList.add(lottoNumbers)
        }
        return LottoNumbersList(lottoNumbersList)
    }

    private fun generate(): LottoNumbers {
        return LottoNumbers(lottoNumbers.shuffled().take(MAXIMUM_LOTTO_NUMBER_LENGTH).sortedBy { it.value })
    }
}
