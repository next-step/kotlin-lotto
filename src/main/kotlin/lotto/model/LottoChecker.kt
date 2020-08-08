package lotto.model

class LottoChecker(winner: WinnerLotto, lottoPaper: LottoPaper) {
    private val lottoPaper: LottoPaper = checkEachLotto(winner, lottoPaper)

    fun getLottos(): LottoPaper {
        return lottoPaper
    }

    fun getEarningRate(): Double {
        return lottoPaper.calculate()
    }

    private fun checkEachLotto(winner: WinnerLotto, lottoPaper: LottoPaper): LottoPaper {
        lottoPaper.checkLottoWin(winner)
        return lottoPaper
    }
}
