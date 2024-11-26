package lotto.domain

class WinningLotto(
    val winningNumbers: Lotto,
    val bonusNumber: LottoNumber,
) {
    fun countMatchingNumbers(targetLotto: Lotto): Int {
        return targetLotto.numbers.count { it in winningNumbers.numbers }
    }

    fun matchBonusNumber(targetLotto: Lotto): Boolean {
        return targetLotto.numbers.contains(bonusNumber)
    }
}
