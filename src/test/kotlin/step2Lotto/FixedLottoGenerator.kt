package step2Lotto

import step2Lotto.domain.LottoGenerator
import step2Lotto.domain.LottoNumber
import step2Lotto.domain.dto.Lotto

class FixedLottoGenerator : LottoGenerator {
    override fun createLotto(): Lotto {
        return Lotto((1..6).map { LottoNumber(it) })
    }
}
