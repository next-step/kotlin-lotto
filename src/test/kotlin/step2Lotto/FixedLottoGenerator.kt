package step2Lotto

import step2Lotto.domain.Lotto
import step2Lotto.domain.LottoGenerator

class FixedLottoGenerator : LottoGenerator {
    override fun execute(): Lotto {
        return Lotto((1..6).toList())
    }
}
