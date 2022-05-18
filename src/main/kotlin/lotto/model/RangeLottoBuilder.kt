package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lottos

class RangeLottoBuilder(val rangeOfNumbers: IntRange, val countOfNumberToSelect: Int, val priceOfLotto: Int) :
    LottoBuilder {
    override fun createLotto(): Lotto {
        val numbers = rangeOfNumbers.shuffled()
            .subList(0, countOfNumberToSelect)
            .toSet()
        return Lotto(numbers)
    }

    fun createLottosByAmount(purchaseAmount: Int): Lottos {
        val countOfLotto = purchaseAmount / this.priceOfLotto
        return this.createLottos(countOfLotto)
    }
}
