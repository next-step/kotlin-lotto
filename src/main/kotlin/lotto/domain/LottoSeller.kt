package lotto.domain

import lotto.util.LottoGenerator
import lotto.util.ManualLottoGenerator
import lotto.util.RandomLottoGenerator

class LottoSeller(amount: Int) {
    private var lottoSize: Int

    init {
        require(amount >= Lotto.LOTTO_PRICE) { MORE_THAN_LOTTO_PRICE_MESSAGE }
        lottoSize = amount / Lotto.LOTTO_PRICE
    }

    fun sellManualLottos(count: Int) = sellLottos(ManualLottoGenerator, count)

    fun sellAutoLottos() = sellLottos(RandomLottoGenerator)

    fun sellLottos(lottoGenerator: LottoGenerator, count: Int = lottoSize): Lottos {
        require(lottoSize >= count) { EXCEED_LOTTO_SIZE_ERROR_MESSAGE }
        lottoSize -= count
        return lottoGenerator.getLottos(count)
    }

    companion object {
        private const val MORE_THAN_LOTTO_PRICE_MESSAGE = "${Lotto.LOTTO_PRICE}이상의 금액을 입력해주세요"
        private const val EXCEED_LOTTO_SIZE_ERROR_MESSAGE = "구매 가능한 로또의 개수를 초과했습니다"
    }
}
