package lotto.model

import lotto.model.data.Lotto

class RangeLottoBuilder(val rangeOfNumbers: IntRange, val countOfNumberToSelect: Int) : LottoBuilder {
    override fun createLotto(): Lotto {
        val numbers = rangeOfNumbers.shuffled()
            .subList(0, countOfNumberToSelect)
            .toSet()
        return Lotto(numbers)
    }
}
