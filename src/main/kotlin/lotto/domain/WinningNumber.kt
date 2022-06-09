package lotto.domain

data class WinningNumber(
    val winningNumbers: List<Int>
) {
    fun hasNumber(lottoNumber: Int): Boolean {
        return winningNumbers.contains(lottoNumber)
    }
}
