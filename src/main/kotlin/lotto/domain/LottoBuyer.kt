package lotto.domain

class LottoBuyer(
    private val money: Int,
    private var lottoBundle: LottoBundle = LottoBundle.EMPTY,
) {

    fun buyAll(lottoSeller: LottoSeller = LottoSeller()): LottoBundle {
        lottoBundle += lottoSeller.sell(money)
        return lottoBundle.copy()
    }

    fun confirmWinning(winningLotto: WinningLotto): WinningResult {
        check(lottoBundle.isNotEmpty()) { "보유한 로또 뭉치가 없습니다" }
        val winnings = lottoBundle.matchWinning(winningLotto)
        return WinningResult(winnings, money)
    }
}
