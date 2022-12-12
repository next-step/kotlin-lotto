package lotto.util

import lotto.common.IntegerNumber

interface NumberGenerator {
    fun generate(start: Int, end: Int, size: Int): List<IntegerNumber>
}
