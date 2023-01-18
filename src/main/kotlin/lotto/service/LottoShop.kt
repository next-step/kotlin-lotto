package lotto.service

import lotto.model.Lotto.Companion.LOTTO_PRICE
import lotto.model.LottoTicket
import lotto.model.Lottos
import lotto.model.Money
import lotto.model.Money.Companion.ZERO


object LottoShop {
    fun buyLottos(money: Money, lottoTicket: LottoTicket = LottoTicket()): Lottos {
        require(money >= LOTTO_PRICE) { "금액은 로또 가격인 ${LOTTO_PRICE}보다 커야합니다." }

        val manualLottos = lottoTicket.toLottos()
        val manualLottosPrice = manualLottos.purchaseAmount
        val autoLottos = buyAutoLottos(money - manualLottosPrice)
        return Lottos(manualLottos.plus(autoLottos))
    }

    private fun buyAutoLottos(leftMoney: Money): Lottos {
        require(leftMoney >= ZERO) { "금액보다 많은 양의 로또를 살 수는 없습니다." }

        val buyCount = leftMoney.getBuyCountOf(LOTTO_PRICE)
        val blankTicket = LottoTicket.getBlankTicket(buyCount)
        return blankTicket.toRandomLottos()
    }
}
