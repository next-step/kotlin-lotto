package lotto.domain

class LottoBuyer(
    private val initialMoney: Money,
    private var lottoBundle: LottoBundle = LottoBundle.EMPTY,
    private var lottoSeller: LottoSeller = LottoSeller()
) {
    var money: Money = initialMoney
        private set

    fun buyAll() {
        val amountOfLotto = lottoSeller.getAvailableAmountOfLotto(money)
        val payment = lottoSeller.getPayment(amountOfLotto).also {
            requireEnoughPayment(it)
        }

        val boughtBundle = lottoSeller.sellAutoLotto(payment)
        lottoBundle += boughtBundle
        money -= payment
    }

    private fun requireEnoughPayment(payment: Money) {
        require(money >= payment) { "보유한 금액으로 로또를 구입할 수 없습니다" }
    }

    fun buy(lottoCoupons: List<LottoCoupon>) {
        val payment = lottoSeller.getPayment(lottoCoupons.size).also {
            requireEnoughPayment(it)
        }

        val boughtBundle = lottoSeller.sellManualLotto(payment, lottoCoupons)
        lottoBundle += boughtBundle
        money -= payment
    }

    fun getLottoBundle(): LottoBundle = lottoBundle.copy()

    fun confirm(winningLotto: WinningLotto): WinningResult {
        check(lottoBundle.isNotEmpty()) { "보유한 로또 뭉치가 없습니다" }
        val winnings = lottoBundle.matchWinning(winningLotto)
        val payment = if (initialMoney == money) initialMoney else initialMoney - money
        return WinningResult(winnings, payment)
    }
}
