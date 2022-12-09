package lotto.service

import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.Lottos
import java.math.BigDecimal
import java.math.RoundingMode

object LottoShop {
    val LOTTO_PRICE = BigDecimal(1000)

    fun buy(money: BigDecimal): Lottos {
        require(money >= LOTTO_PRICE)
        val buyCount = money.divide(LOTTO_PRICE, 0, RoundingMode.FLOOR).toInt()
        val lottoList = List(buyCount) { Lotto.randomLotto() }
        return Lottos(lottoList)
    }

    fun prizeOf(matchCount: Int): BigDecimal {
        return LottoPrize.of(matchCount).prize
    }
}
