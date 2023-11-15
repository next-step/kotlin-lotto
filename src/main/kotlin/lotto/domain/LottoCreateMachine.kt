package lotto.domain

import lotto.domain.model.vo.BuyPrice
import lotto.domain.model.Lotto
import lotto.domain.model.vo.Price

/**
 * 로또 생성 기계
 * */
object LottoCreateMachine {

    /**
     * 로또 리스트 구매
     * */
    fun buyLottoList(buyPrice: BuyPrice, price: Price = Price.valueOf()): List<Lotto> {
        return createLottoList(buyPrice.buyPrice / price.price)
    }

    private fun createLottoList(lottoCount: Int): List<Lotto> {
        return List(lottoCount) { createLotto() }
    }

    private fun createLotto(): Lotto {
        return Lotto.from()
    }
}
