package Lotto

import Lotto.domain.Lotto
import Lotto.domain.LottoGenerator
import Lotto.domain.LottoNumber

class FixedLottoGenerator : LottoGenerator {
    override fun createLotto(): Lotto {
        return Lotto((1..6).map { LottoNumber(it) })
    }
}
