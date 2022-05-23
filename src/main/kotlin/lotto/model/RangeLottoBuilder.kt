package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lotto.Companion.toLotto
import lotto.model.data.LottoNumberRange
import lotto.model.data.Lottos
import lotto.model.data.Policy

class RangeLottoBuilder(val policy: Policy) : LottoBuilder {

    override fun createLotto(): Lotto {
        return policy.rangeOfNumbers
            .selectNumbers(policy.countOfNumberToSelect)
            .toLotto(policy)
    }

    fun createLottosByAmount(purchaseAmount: Int): Lottos {
        val countOfLotto = purchaseAmount / policy.priceOfLotto
        return this.createLottos(countOfLotto)
    }

    private fun LottoNumberRange.selectNumbers(count: Int) = this.shuffled().subList(0, count)
}
