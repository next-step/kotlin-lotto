package lotto.domain

import lotto.domain.lottogenerator.ManualLottoGenerator
import lotto.domain.lottogenerator.RandomLottoGenerator

class LottosMachine(
    private val purchase: Money,
    private val manualLottoGenerators: List<ManualLottoGenerator>
) {

    init {
        require((purchase / Lotto.PRICE).toInt() >= manualLottoGenerators.size) {
            "수동 구매 금액이 입력 금액보다 큽니다. 구매 금액: $purchase, 수동 구매 개수: $manualLottoGenerators.size"
        }
    }

    constructor(purchase: Money) : this(purchase, listOf())

    fun create(): Lottos {
        val totalCount = (purchase / Lotto.PRICE).toInt()
        val manualCount = manualLottoGenerators.size
        val randomCount = totalCount - manualCount

        val randomLottoGenerators = (1..randomCount).map { RandomLottoGenerator }
        val lottoGenerators = manualLottoGenerators.plus(randomLottoGenerators)

        return Lottos(lottoGenerators.map { it.generate() })
    }
}
