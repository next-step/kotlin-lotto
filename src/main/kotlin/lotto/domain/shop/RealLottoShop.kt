package lotto.domain.shop

import math.PositiveNumber

class RealLottoShop(
    private val lottoGameMachine: LottoGameMachine,
) : LottoShop {

    override fun purchase(lottoPurchaseAmount: PositiveNumber): LottoPurchaseResult {
        return LottoPurchaseResult(
            lottoGames = List(lottoPurchaseAmount / LOTTO_PRICE) {
                lottoGameMachine.create()
            }
        )
    }

    companion object {

        private const val LOTTO_PRICE = 1_000
    }
}
