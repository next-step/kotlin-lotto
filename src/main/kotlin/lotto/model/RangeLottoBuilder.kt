package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lotto.Companion.parseToLotto
import lotto.model.data.LottoNumbers
import lotto.model.data.Lottos
import lotto.model.data.ParseResult
import lotto.model.data.Policy

class RangeLottoBuilder(val policy: Policy) : LottoBuilder {

    override fun createLotto(): Lotto {
        val lottoNumbers = LottoNumbers(policy.randomNumbers())
        val parsedLotto = lottoNumbers.parseToLotto(policy) as ParseResult.Value<Lotto>
        return parsedLotto.value
    }

    fun createLottosByAmount(purchaseAmount: Int): Lottos {
        val countOfLotto = purchaseAmount / policy.priceOfLotto
        return this.createLottos(countOfLotto)
    }
}
