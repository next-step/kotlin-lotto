package lotto.service

import lotto.model.Lotto.Companion.LOTTO_PRICE
import lotto.model.Lottos
import java.math.BigDecimal
import java.math.RoundingMode.FLOOR

object LottoShop {
    private const val LOTTO_MONEY_SCALE = 0

    fun buyAutoLottos(money: BigDecimal): Lottos {
        val buyCount = money.pay(LOTTO_PRICE)
        val lottoList = List(buyCount) { LottoGenerator.getRandomLotto() }
        return Lottos(lottoList)
    }

    private fun BigDecimal.pay(lottoPrice: BigDecimal): Int {
        require(this >= lottoPrice) {
            "금액은 로또 가격인 ${lottoPrice}보다 커야합니다. money: $this"
        }

        return this.divide(LOTTO_PRICE, LOTTO_MONEY_SCALE, FLOOR).toInt()
    }
}
