package lotto.domain

import lotto.domain.model.BuyPrice
import lotto.domain.model.Lotto
import lotto.domain.model.Lottos
import lotto.domain.model.Price
import lotto.util.isNotInfinite
import lotto.util.isNotNan

/**
 * 로또 생성 기계
 * */
object AutoLottoCreateMachine {

    private const val MIN_LOTTO_COUNT = 1
    private const val DEFAULT_REMAINDER = 0.0

    /**
     * 로또 리스트 구매
     * */
    fun buyAutoLottoList(selfLottosSize: Int, buyPrice: BuyPrice, price: Price = Price.valueOf()): Lottos {

        require(buyPrice.value.toDouble() % price.value.toDouble() == DEFAULT_REMAINDER) {
            "구입금액을 로또가격으로 나눴을때 나머지가 ${MIN_LOTTO_COUNT}이여야 합니다."
        }

        val lottoCount: Double = (buyPrice.toDouble() / price.toDouble())

        require(lottoCount.isNotNan() && lottoCount.isNotInfinite()) {
            "구입금액을 로또가격으로 나눴을때 NaN, Infinite가 나오면 안됩니다."
        }

        require(lottoCount.toInt() - selfLottosSize >= MIN_LOTTO_COUNT) {
            "구입금액을 로또가격으로 나눈 값에 수동으로 구매한 ${selfLottosSize}개를 뺐을 때 ${MIN_LOTTO_COUNT}보다 큰수가 나와야 합니다."
        }

        return Lottos.from(List(lottoCount.toInt() - selfLottosSize) { Lotto.auto() })
    }
}
