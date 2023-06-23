package lotto.domain

import lotto.LottoGame
import lotto.util.LottoGenerator
import lotto.util.ManualLottoGenerator
import lotto.util.RandomLottoGenerator

class LottoSeller(manualLottoCommand: () -> List<LottoNumber>) {
    private val manualLottoGenerator = ManualLottoGenerator(manualLottoCommand)

    fun sellManualLottos(amount: Int, count: Int) = LottoSellingMachine.sellLottos(amount, manualLottoGenerator, count)

    fun sellAutoLottos(amount: Int) = LottoSellingMachine.sellLottos(amount, RandomLottoGenerator)
}

object LottoSellingMachine {
    fun sellLottos(amount: Int, lottoGenerator: LottoGenerator, count: Int? = null): LottoSellResponse {
        val count = count ?: (amount / Lotto.LOTTO_PRICE) // 개수를 넣지 않으면 구매 가능한 최대한의 수량으로 구매한다
        require(amount / Lotto.LOTTO_PRICE >= count) { LottoGame.EXCEED_LOTTO_SIZE_ERROR_MESSAGE }

        return LottoSellResponse(lottoGenerator.getLottos(count), amount - (count * Lotto.LOTTO_PRICE))
    }

    data class LottoSellResponse(val lottos: Lottos, val change: Int)
}
