package lotto.domain

class WinningNumber(private val winningLottoNumber: List<Int>) {

    init {
        LotteryPaper.validateLottoNumber(winningLottoNumber)
    }

    fun getWinningLottoNumber(): List<Int> {
        return winningLottoNumber.toList()
    }
}
