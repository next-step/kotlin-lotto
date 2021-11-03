package lotto.domain.strategy

import lotto.domain.Lottery

interface LottoGenerator {

    fun generate(): Lottery
}
