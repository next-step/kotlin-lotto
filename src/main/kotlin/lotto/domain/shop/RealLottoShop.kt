package lotto.domain.shop

class RealLottoShop : LottoShop {

    override fun purchase(lottoPurchaseAmount: Int): LottoPurchaseResult {
        return LottoPurchaseResult(
            lottoGames = List(lottoPurchaseAmount / 1000) {
                LottoGame(
                    numbers = (1..45).shuffled().take(6).sorted()
                )
            }
        )
    }
}
