package lotto.domain

class LottoBuyer(
    private val initialMoney: Money,
    private var lottoBundle: LottoBundle = LottoBundle.EMPTY,
) {
    var money: Money = initialMoney
        private set

    fun buyAll(lottoSeller: LottoSeller = LottoSeller()) {
        val (boughtBundle, changes) = lottoSeller.sellAutoLotto(money)
        lottoBundle += boughtBundle
        money = changes
    }

    fun buy(lottoCoupons: List<LottoCoupon>, lottoSeller: LottoSeller = LottoSeller()) {
        val (boughtBundle, changes) = lottoSeller.sellManualLotto(money, lottoCoupons)
        lottoBundle += boughtBundle
        money = changes
    }

    fun getLottoBundle(): LottoBundle = lottoBundle.copy()

    fun confirm(winningLotto: WinningLotto): WinningResult {
        check(lottoBundle.isNotEmpty()) { "보유한 로또 뭉치가 없습니다" }
        val winnings = lottoBundle.matchWinning(winningLotto)
        return WinningResult(winnings, if (initialMoney == money) initialMoney else initialMoney - money)
    }
}
