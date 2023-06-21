package lotto.domain

class WinningNumber() {

    private lateinit var winningLottoNumber: List<Int>
    fun generateWinningNumber(input: List<Int>) {
        validateInputNumbersInLottoNumberBounds(input)
        winningLottoNumber = input
    }

    private fun validateInputNumbersInLottoNumberBounds(input: List<Int>) {
        input.forEach {
            require(it in LottoNumberBounds) { "로또 범위의 숫자만 가능합니다. 입력값을 다시 확인하세요." }
        }
    }

    fun getWinningLottoNumber(): List<Int> {
        return winningLottoNumber.toList()
    }

    companion object {
        val LottoNumberBounds = LotteryPaper.MINIMUM_NUMBER..LotteryPaper.MAXIMUM_NUMBER
    }
}