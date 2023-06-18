package lotto.domain.shop

import common.PositiveNumber

class RealLottoShop : LottoShop {

    override fun purchase(lottoPurchaseAmount: PositiveNumber): LottoPurchaseResult {
        return LottoPurchaseResult(
            lottoGames = List(lottoPurchaseAmount.value / 1000) {
                LottoGame(
                    numbers = LottoNumber.allLottoNumbers().shuffled().take(6).sorted()
                )
            }
        )
    }
}
