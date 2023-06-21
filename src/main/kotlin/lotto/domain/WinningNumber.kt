package lotto.domain

class WinningNumber() {

    private lateinit var winningLottoNumber: List<Int>
    fun generateWinningNumber(input: List<Int>) {
        LotteryPaper.validateLottoNumber(input)
        winningLottoNumber = input
    }


    fun getWinningLottoNumber(): List<Int> {
        return winningLottoNumber.toList()
    }

}