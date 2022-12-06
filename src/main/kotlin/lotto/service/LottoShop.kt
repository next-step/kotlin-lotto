package lotto.service

import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.Lottos
import java.math.BigDecimal
import java.math.RoundingMode

object LottoShop {
    fun buy(money: BigDecimal): Lottos {
        require(money >= BigDecimal(1000))
        val buyCount = money.divide(BigDecimal(1000), 0, RoundingMode.FLOOR).toInt()
        val lottoList = List<Lotto>(buyCount) { Lotto.of(listOf(1, 2, 3, 4, 5, 6)) }
        return Lottos(lottoList)
    }

    fun prizeOf(matchCount: Int): BigDecimal {
        return LottoPrize.of(matchCount).prize
    }
}
