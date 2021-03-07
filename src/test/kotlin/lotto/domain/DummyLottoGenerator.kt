package lotto.domain

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import java.lang.RuntimeException

class DummyLottoGenerator: LottoGenerator {
    override fun generate(): Lotto {
        throw RuntimeException("dummy 구현체에서 구현되지 않은 메서드")
    }
}
