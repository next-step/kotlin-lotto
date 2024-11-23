package lotto.domain

class LottoUser(
    val lottoPurchaseAmount: LottoPurchaseAmount,
) {
    private val lottoCount = lottoPurchaseAmount.calculateLottoCount()
    val lotteries: List<Lotto> = List(lottoCount) { Lotto() }
}
