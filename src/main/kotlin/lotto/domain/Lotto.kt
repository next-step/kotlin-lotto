package lotto.domain

import lotto.util.RandomUtil

class Lotto(
    var lottoNumbers: List<Int> = emptyList()
) {
    private val numberRange = (1..45)
    private val size = 6
    init {
        lottoNumbers = RandomUtil.generateNumbers(numberRange, size)
    }
}
