package lotto.domain.lottoStrategy

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object NormalLottoStrategy : LottoStrategy {
    override val numberRange: IntRange = 1..45
    override val numberCount: Int = 6

    override fun makeLottoNumbers(): Lotto {
        val lottos =
            numberRange
                .shuffled()
                .take(numberCount)
                .sorted()
                .map { LottoNumber(it) }

        return Lotto(lottos)
    }
}
