package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Policy

class RangeLottoBuilder(val policy: Policy) :
    LottoBuilder {
    override fun createLotto(): Lotto {
        val numbers = policy.rangeOfNumbers.shuffled()
            .subList(0, policy.countOfNumberToSelect)
            .toSet()
        return Lotto(numbers)
    }

    fun createLottosByAmount(purchaseAmount: Int): Lottos {
        val countOfLotto = purchaseAmount / policy.priceOfLotto
        return this.createLottos(countOfLotto)
    }
}
