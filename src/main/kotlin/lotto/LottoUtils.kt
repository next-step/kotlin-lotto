package lotto

import lotto.domain.BonusNumber
import lotto.domain.LottoNumbers
import lotto.domain.LuckyNumbers

private val DEFAULT_RANGE = 1..45
const val LOTTO_NUMBERS_SIZE = 6
const val LOTTO_PRICE = 1000

object LottoUtils {
    lateinit var luckyNumbers: LuckyNumbers
    lateinit var bonusNumber: BonusNumber

    fun provideNumbers(): LottoNumbers {
        return LottoNumbers(makeAutoNumbers())
    }

    private fun makeAutoNumbers() = DEFAULT_RANGE.shuffled().take(LOTTO_NUMBERS_SIZE).sorted()
}
