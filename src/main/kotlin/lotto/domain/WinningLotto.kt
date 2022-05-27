package lotto.domain

import lotto.domain.numbers.CustomNumbersGenerator
import lotto.domain.numbers.LottoNumbersGenerator

class WinningLotto(winningNumbers: List<Int>, generator: LottoNumbersGenerator = CustomNumbersGenerator(winningNumbers)) {
    val winningNumbers = generator.generate()

    fun getNumberOfMatchingNumbers(lotto: Lotto): Int = winningNumbers.intersect(lotto.numbers.toSet()).size
}
