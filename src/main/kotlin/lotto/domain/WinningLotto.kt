package lotto.domain

import lotto.domain.numbers.LottoNumbers

class WinningLotto(winningNumbers: List<Int>) {
    val winningNumbers = LottoNumbers(winningNumbers)
    fun getNumberOfMatchingNumbers(lotto: Lotto): Int = winningNumbers.list.intersect(lotto.numbers.list.toSet()).size
}
