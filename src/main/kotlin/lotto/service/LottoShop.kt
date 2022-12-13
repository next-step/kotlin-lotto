package lotto.service

import lotto.model.Lotto.Companion.LOTTO_PRICE
import lotto.model.Lottos
import java.math.BigDecimal
import java.math.RoundingMode.FLOOR

object LottoShop {
    private const val LOTTO_MONEY_SCALE = 0

    fun buyAutoLottos(money: BigDecimal): Lottos {
        require(money >= LOTTO_PRICE) {
            "money 값은 로또 가격인 ${LOTTO_PRICE}보다 커야합니다. money: ${money}"
        }

        val buyCount = getBuyCountOf(money)
        val lottoList = List(buyCount) { LottoGenerator.getRandomLotto() }
        return Lottos(lottoList)
    }

    private fun getBuyCountOf(money: BigDecimal) =
        money.divide(LOTTO_PRICE, LOTTO_MONEY_SCALE, FLOOR).toInt()
}
