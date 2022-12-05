package lotto.service

import lotto.model.Lottos
import java.math.BigDecimal

object LottoShop {
    fun buy(i: Int): Lottos {
        return Lottos(listOf())
    }

    fun prizeOf(matchCount: Int): BigDecimal {
        return BigDecimal.ZERO
    }

    fun returnRatioOf(lottoCount: Int, winningPrize: Int): BigDecimal {
        return BigDecimal.ZERO
    }
}
