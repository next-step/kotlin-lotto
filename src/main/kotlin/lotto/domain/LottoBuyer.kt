package lotto.domain

class LottoBuyer(
    private val money: Int,
    private val lottoSeller: LottoSeller = LottoSeller(),
    ownLottoBundle: LottoBundle? = null,
) {
    private lateinit var lottoBundle: LottoBundle

    init {
        if (ownLottoBundle != null) {
            lottoBundle = ownLottoBundle
        }
    }

    fun buyAll() {
        lottoBundle = lottoSeller.sell(money)
    }

    fun confirmWinning(winningLotto: Lotto): WinningResult {
        check(this::lottoBundle.isInitialized) { "보유한 로또 뭉치가 없습니다" }
        val winnings = lottoBundle.matchWinning(winningLotto)
        return WinningResult(winnings, money)
    }
}

data class WinningResult(
    private val winnings: List<WinningPlace>,
    private val cost: Int
) {
    private val totalReword = winnings.fold(0) { reword, winning ->
        reword + winning.reward
    }
    val rateOfReturn = totalReword / cost.toDouble()

    val groupByWinningPlace = winnings.groupBy({ it }, { it.reward })
}
