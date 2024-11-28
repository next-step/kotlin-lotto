package lotto.strategy

import lotto.stretagy.NumberListGenerator

class FixedNumberListGenerator : NumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}
