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

    fun buyAll(): LottoBundle {
        lottoBundle = lottoSeller.sell(money)
        return lottoBundle.copy()
    }

    fun confirmWinning(winningNumbers: WinningNumbers): WinningResult {
        check(this::lottoBundle.isInitialized) { "보유한 로또 뭉치가 없습니다" }
        val winnings = lottoBundle.matchWinning(winningNumbers)
        return WinningResult(winnings, money)
    }
}
