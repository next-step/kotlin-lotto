package org.bmsk.domain.model.random

internal class LottoRandomGenerator : RandomGenerator {
    override fun generate(exceptionNumbers: List<Int>): Int {
        return (1..45)
            .filterNot { it in exceptionNumbers }
            .random()
    }
}
