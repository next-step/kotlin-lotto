package lotto

import lotto.domain.strategy.NumberGenerator

object TestNumberGenerator: NumberGenerator {
    override fun generate(size: Int): List<Int> = listOf(7, 5, 1, 3, 9, 8)
}