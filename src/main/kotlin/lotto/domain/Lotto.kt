package lotto.domain

@JvmInline
value class Lotto(
    private val lottoNumbers: LottoNumbers,
) {
    fun matchWinningNumber(winningNumbers: List<LottoNumber>): Int {
        return winningNumbers.count {
            lottoNumbers.containsWinningNumbers(it.value)
        }
    }

    fun matchBonusNumber(bonusNumber: Int): Boolean {
        return lottoNumbers.containsBonusNumber(bonusNumber)
    }

    fun getLottoNumbers(): List<Int> {
        return lottoNumbers.value.map { it.value }
    }
}
