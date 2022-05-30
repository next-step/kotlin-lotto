package lotto.domain

import lotto.domain.numbers.LottoNumbers

class WinningLotto(winningNumbers: List<Int>, val bonusNumber: Int) {
    val winningNumbers = LottoNumbers(winningNumbers)

    init {
        require(!winningNumbers.contains(bonusNumber))
    }
    fun getNumberOfMatchingNumbers(lotto: Lotto): Int = winningNumbers.list.intersect(lotto.numbers.list.toSet()).size
}
