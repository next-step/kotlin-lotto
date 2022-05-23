package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lotto.Companion.parseToLotto
import lotto.model.data.LottoNumberRange
import lotto.model.data.LottoNumbers.Companion.toLottoNumbers
import lotto.model.data.Lottos
import lotto.model.data.ParseResult
import lotto.model.data.Policy

class RangeLottoBuilder(val policy: Policy) : LottoBuilder {

    override fun createLotto(): Lotto {
        val lottoNumbers = policy.rangeOfNumbers
            .selectNumbers(policy.countOfNumberToSelect)
            .map { it.number }
            .toLottoNumbers()

        return (lottoNumbers.parseToLotto(policy) as ParseResult.Value<Lotto>).value
    }

    fun createLottosByAmount(purchaseAmount: Int): Lottos {
        val countOfLotto = purchaseAmount / policy.priceOfLotto
        return this.createLottos(countOfLotto)
    }

    private fun LottoNumberRange.selectNumbers(count: Int) = this.shuffled().subList(0, count)
}
