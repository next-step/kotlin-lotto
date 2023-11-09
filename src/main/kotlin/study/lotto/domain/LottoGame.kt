package study.lotto.domain

class LottoGame(purchaseAmount: Int) {

    init {
        require(purchaseAmount >= 0) {
            "purchaseAmount must be a positive value"
        }
    }

    val buyingLottoes: Lottoes = Lottoes.generateLottoes(purchaseAmount / Lotto.PRICE_PER_TICKET)
    fun getResult(lastWeekWinningLotto: Lotto) = lastWeekWinningLotto.let { LottoGameResult.getResult(buyingLottoes, lastWeekWinningLotto) }
}
