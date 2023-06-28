package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber

class FixedLottoGenerator : LottoGenerator {
    override fun createLotto(): Lotto {
        return Lotto((1..6).map { LottoNumber(it) })
    }
}
