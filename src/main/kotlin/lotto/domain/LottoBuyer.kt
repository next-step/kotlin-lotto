package lotto.domain

class LottoBuyer(
    private val initialMoney: Int,
    private var lottoBundle: LottoBundle = LottoBundle.EMPTY,
) {
    var money: Int = initialMoney
        private set

    fun buyAll(lottoSeller: LottoSeller = LottoSeller()): Int {
        val (boughtBundle, changes) = lottoSeller.sellAutoLotto(money)
        lottoBundle += boughtBundle
        money = changes
        return boughtBundle.size
    }

    fun buy(lottoCoupons: List<LottoCoupon>, lottoSeller: LottoSeller = LottoSeller()): Int {
        val (boughtBundle, changes) = lottoSeller.sellManualLotto(money, lottoCoupons)
        lottoBundle += boughtBundle
        money = changes
        return boughtBundle.size
    }

    fun getLottoBundle(): LottoBundle = lottoBundle.copy()

    fun confirm(winningLotto: WinningLotto): WinningResult {
        check(lottoBundle.isNotEmpty()) { "보유한 로또 뭉치가 없습니다" }
        val winnings = lottoBundle.matchWinning(winningLotto)
        return WinningResult(winnings, if (initialMoney == money) initialMoney else initialMoney - money)
    }
}
