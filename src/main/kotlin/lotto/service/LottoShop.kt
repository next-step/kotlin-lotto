package lotto.service

import lotto.model.Lotto
import lotto.model.Lotto.Companion.LOTTO_PRICE
import lotto.model.Lottos
import java.math.BigDecimal
import java.math.RoundingMode

object LottoShop {
    fun buy(money: BigDecimal): Lottos {
        require(money >= LOTTO_PRICE)
        val buyCount = money.divide(LOTTO_PRICE, 0, RoundingMode.FLOOR).toInt()
        val lottoList = List(buyCount) { Lotto.randomLotto() }
        return Lottos(lottoList)
    }
}
