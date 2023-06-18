package lotto.domain.shop

import common.PositiveNumber
import lotto.domain.shop.machine.LottoGameMachine

class RealLottoShop(
    private val lottoGameMachine: LottoGameMachine,
) : LottoShop {

    override fun purchase(lottoPurchaseAmount: PositiveNumber): LottoPurchaseResult {
        return LottoPurchaseResult(
            lottoGames = List(lottoPurchaseAmount.value / 1000) {
                lottoGameMachine.create()
            }
        )
    }
}
