package lotto.util

import lotto.common.Number

interface NumberGenerator {
    fun generate(start: Int, end: Int, size: Int): List<Number>
}
