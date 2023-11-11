package lotto.domain

data class LottoLine(
    val line: List<LottoNumber>
) {
    fun getSameNumberCount(winningNumbers : LottoLine) = line.count { winningNumbers.line.contains(it) }
    fun isContainsBonusNumber(bonusNumber: LottoNumber) = line.contains(bonusNumber)
}
