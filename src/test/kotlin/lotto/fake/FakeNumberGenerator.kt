package lotto.fake

import lotto.domain.NumberGenerator

class FakeNumberGenerator(
    private val numbers: List<Int>
) : NumberGenerator {
    override fun generate(): List<Int> {
        return numbers
    }
}