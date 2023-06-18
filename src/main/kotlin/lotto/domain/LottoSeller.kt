package lotto.domain

import lotto.util.LottoGenerator

class LottoSeller(private val lottoGenerator: LottoGenerator) {

    fun sellLottos(amount: Int): Lottos {
        require(amount >= Lotto.LOTTO_PRICE) { MORE_THAN_LOTTO_PRICE_MESSAGE }
        val count = amount / Lotto.LOTTO_PRICE
        return Lottos(Array(count) { lottoGenerator.getLotto() }.toList())
    }

    companion object {
        private const val MORE_THAN_LOTTO_PRICE_MESSAGE = "${Lotto.LOTTO_PRICE}이상의 금액을 입력해주세요"
    }
}
