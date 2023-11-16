package lotto.domain

import lotto.domain.strategy.NumberGenerator

@JvmInline
value class Lotto(
    val numbers: List<Int>
) {

    companion object {
        fun create(generator: NumberGenerator): Lotto {
            return Lotto(generator.generate(6))
        }
    }
}
