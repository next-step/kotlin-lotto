package lotto.domain

import lotto.domain.model.vo.BuyPrice
import lotto.domain.model.Lotto
import lotto.domain.model.vo.Price

/**
 * 로또 생성 기계
 * */
object LottoCreateMachine {

    private const val MIN_LOTTO_COUNT = 1
    private const val DEFAULT_REMAINDER = 0.0

    /**
     * 로또 리스트 구매
     * */
    fun buyLottoList(buyPrice: BuyPrice, price: Price = Price.valueOf()): List<Lotto> {

        require(buyPrice.buyPrice.toDouble() % price.price.toDouble() == DEFAULT_REMAINDER) {
            "구입금액을 로또가격으로 나눴을때 나머지가 ${MIN_LOTTO_COUNT}이여야 합니다."
        }

        val lottoCount: Double = (buyPrice.buyPrice.toDouble() / price.price.toDouble())

        require(!lottoCount.isNaN() && !lottoCount.isInfinite()) {
            "구입금액을 로또가격으로 나눴을때 NaN, Infinite가 나오면 안됩니다."
        }

        require(lottoCount.toInt() >= MIN_LOTTO_COUNT) {
            "구입금액을 로또가격으로 나눴을때 ${MIN_LOTTO_COUNT}보다 큰수가 나와야 합니다."
        }

        return createLottoList(lottoCount.toInt())
    }

    private fun createLottoList(lottoCount: Int): List<Lotto> {
        return List(lottoCount) { createLotto() }
    }

    private fun createLotto(): Lotto {
        return Lotto.from()
    }
}
