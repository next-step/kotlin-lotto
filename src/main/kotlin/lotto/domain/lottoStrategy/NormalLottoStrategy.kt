package lotto.domain.lottoStrategy

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object NormalLottoStrategy : LottoStrategy {
    override fun makeLotto(): Lotto {
        val lottoNumbers =
            LottoNumber.LOTTO_NUMBER_RANGE
                .shuffled()
                .take(Lotto.LOTTO_SIZE)
                .sorted()
                .map { LottoNumber(it) }

        return Lotto(lottoNumbers)
    }
}
