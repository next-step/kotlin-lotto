package lotto.domain

import lotto.domain.lottogenerator.LottoGenerator
import lotto.domain.lottogenerator.RandomLottoGenerator

class LottosMachine(
    private val purchase: Money,
    private val manualLottoGenerators: List<LottoGenerator>
) {
    private val totalCount = (purchase / Lotto.PRICE).toInt()
    private val manualCount = manualLottoGenerators.size

    init {
        require(totalCount >= manualCount) {
            "수동 구매 금액이 입력 금액보다 큽니다. 구매 금액: $purchase, 수동 구매 개수: $manualCount"
        }
    }

    fun create(): Lottos {
        val randomCount = totalCount - manualCount

        val randomLottoGenerators = (1..randomCount).map { RandomLottoGenerator }
        val lottoGenerators = manualLottoGenerators.plus(randomLottoGenerators)

        return Lottos(lottoGenerators.map { it.generate() })
    }
}
