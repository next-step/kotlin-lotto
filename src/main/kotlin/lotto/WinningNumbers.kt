package lotto

class WinningNumbers(private val winningNumbers: List<Int>) {
    fun isContained(lottoNumber: Int): Boolean {
        return winningNumbers.contains(lottoNumber)
    }

    companion object {
        fun getInstance(winningNumbers: List<Int>): WinningNumbers {
            return WinningNumbers(winningNumbers)
        }
    }
}
