package lotto.util

import lotto.application.common.Number

class RandomNumberGenerator: NumberGenerator {
    override fun generate(start: Int, end: Int, size: Int): List<Number> {
        val range = start..end
        val shuffled = range.shuffled()
        val subList = shuffled.subList(0, size)
        return subList.map { Number(it) }
    }
}
