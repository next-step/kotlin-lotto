package step2Lotto

import step2Lotto.domain.LottoGenerator
import step2Lotto.domain.dto.Lotto

class FixedLottoGenerator : LottoGenerator {
    override fun execute(): Lotto {
        return Lotto((1..6).toList())
    }
}
