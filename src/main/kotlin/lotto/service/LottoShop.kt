package lotto.service

import lotto.model.Lotto.Companion.LOTTO_PRICE
import lotto.model.Lottos
import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.math.RoundingMode.FLOOR

object LottoShop {
    private const val LOTTO_MONEY_SCALE = 0

    fun buyLottos(money: BigDecimal, manualNumbers: List<String> = listOf()): Lottos {
        require(money >= LOTTO_PRICE) { "금액은 로또 가격인 ${LOTTO_PRICE}보다 커야합니다." }

        val manualLottosPrice = getManualLottosPrice(manualNumbers)
        val manualLottos = manualNumbers.map { LottoGenerator.fromString(it) }
        val autoLottos = buyAutoLottos(money - manualLottosPrice)
        return Lottos(manualLottos.plus(autoLottos))
    }

    private fun buyAutoLottos(leftMoney: BigDecimal): Lottos {
        require(leftMoney >= ZERO) { "금액보다 많은 양의 로또를 살 수는 없습니다." }

        val buyCount = getBuyCountOf(leftMoney)
        val lottoList = List(buyCount) { LottoGenerator.getRandomLotto() }
        return Lottos(lottoList)
    }

    private fun getManualLottosPrice(manualLottoNumbers: List<String>): BigDecimal {
        return LOTTO_PRICE * BigDecimal(manualLottoNumbers.size)
    }

    private fun getBuyCountOf(money: BigDecimal): Int {
        return money.divide(LOTTO_PRICE, LOTTO_MONEY_SCALE, FLOOR).toInt()
    }
}
