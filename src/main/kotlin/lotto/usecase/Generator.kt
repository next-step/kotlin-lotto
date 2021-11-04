package lotto.usecase

import lotto.domain.Lotto

interface Generator {
    fun generate(
        numbers: List<Int>,
        price: Int,
    ): Lotto
}
