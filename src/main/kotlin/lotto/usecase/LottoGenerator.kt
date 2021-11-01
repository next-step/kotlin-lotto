package lotto.usecase

import lotto.domain.Lotto

class LottoGenerator : Generator {

    override fun generate(
        numbers: List<Int>,
        price: Int,
    ): Lotto {
        return Lotto(
            numbers = numbers,
            price = price
        )
    }
}
