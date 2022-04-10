package lotto.domain.shop

import lotto.domain.money.BuyMoney
import lotto.domain.ticket.LottoGame

object LottoShop {
    private const val START_TICKET = 1

    fun quickPickBuy(money: BuyMoney): List<LottoGame> {
        return (START_TICKET..money.howManyBuyTicket).map {
            LottoGame.quickPick()
        }
    }
}
