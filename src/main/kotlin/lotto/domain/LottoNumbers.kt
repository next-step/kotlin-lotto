package lotto.domain

import lotto.domain.numberGenerator.NumberGenerator

class LottoNumbers(numberGenerator: NumberGenerator) {

    val lottoNumbers: List<Int> = numberGenerator.generateNumbers()

    fun countMatches(winningNumbers: List<Int>): Int {
        return lottoNumbers.count { it in winningNumbers }
    }
}
