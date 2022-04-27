package lotto.domain.shop

import lotto.domain.money.BuyMoney
import lotto.domain.ticket.LottoGame

object LottoShop {
    private const val STARTING_LOTTO_GAME = 1

    fun quickPickBuy(money: BuyMoney): List<LottoGame> {
        return (STARTING_LOTTO_GAME..money.howManyBuyLottoGames).map {
            LottoGame.quickPick()
        }
    }
}
