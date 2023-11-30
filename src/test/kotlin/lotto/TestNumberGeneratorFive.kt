package lotto

import lotto.domain.strategy.NumberGenerator

object TestNumberGeneratorFive: NumberGenerator {
    override fun generate(size: Int): List<Int> = listOf(1, 2, 3, 4, 5, 7)
}