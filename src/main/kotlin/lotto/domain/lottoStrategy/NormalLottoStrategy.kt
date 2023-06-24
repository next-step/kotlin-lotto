package lotto.domain.lottoStrategy

import lotto.domain.LottoNumbers

object NormalLottoStrategy : LottoStrategy {
    override val numberRange: IntRange = 1..45
    override val numberCount: Int = 6

    override fun makeLottoNumbers(): LottoNumbers {
        val lottoNumbers = numberRange.shuffled().take(numberCount).sorted()

        return LottoNumbers(lottoNumbers)
    }
}
