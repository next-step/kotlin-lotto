package step2Lotto

import step2Lotto.domain.Lotto
import step2Lotto.domain.LottoGenerator
import step2Lotto.domain.LottoNumber

class FixedLottoGenerator : LottoGenerator {
    override fun createLotto(): Lotto {
        return Lotto((1..6).map { LottoNumber(it) })
    }
}
