package lotto.domain

@JvmInline
value class Lotto(
    private val lottoNumbers: LottoNumber,
) {
    fun matchWinningNumber(winningNumbers: List<Int>): Int {
        return winningNumbers.count {
            lottoNumbers.containsWinningNumbers(it)
        }
    }

    fun getLottoNumbers(): List<Int> = lottoNumbers.value.toList()
}
