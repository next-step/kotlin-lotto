package lotto.util

import lotto.common.IntegerNumber

class RandomNumberGenerator : NumberGenerator {
    override fun generate(start: Int, end: Int, size: Int): List<IntegerNumber> {
        val range = start..end
        val shuffled = range.shuffled()
        val subList = shuffled.subList(0, size)
        return subList.map { IntegerNumber(it) }
    }
}
