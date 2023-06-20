package lotto.domain

import lotto.domain.model.Lotto

class LottoValidator(private val winningNumbers: List<Int>) {

    fun winningCount(lotto: Lotto): Int {
        return lotto.numbers.filter { it in winningNumbers }.size
    }
}
