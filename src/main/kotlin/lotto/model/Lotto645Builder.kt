package lotto.model

import lotto.model.data.Lotto

class Lotto645Builder : LottoBuilder {
    override fun createLotto(): Lotto {
        val numbers = (1..45).shuffled()
            .subList(0, 6)
            .toSet()
        return Lotto(numbers)
    }
}
