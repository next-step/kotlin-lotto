package lotto.domain

import lotto.domain.generator.AutoLottoGenerator
import lotto.domain.generator.LottoGenerator

data class Lotto(private val generator: LottoGenerator = AutoLottoGenerator) {
    private val numbers = generator.execute().sorted()

    override fun toString() = "[${numbers.joinToString()}]"

    fun getMatchCount(other: Lotto) = (numbers + other.numbers).groupingBy { it }.eachCount().count { it.value > 1 }
}
