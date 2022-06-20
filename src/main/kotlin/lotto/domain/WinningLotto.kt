package lotto.domain

data class WinningLotto(
    val winningNumbers: List<Int>
) {
    fun hasNumber(lottoNumber: Int): Boolean {
        return winningNumbers.contains(lottoNumber)
    }
}
