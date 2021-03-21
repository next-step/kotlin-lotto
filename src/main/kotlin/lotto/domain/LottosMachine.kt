package lotto.domain

import lotto.domain.lottogenerator.ManualLottoGenerator
import lotto.domain.lottogenerator.RandomLottoGenerator

class LottosMachine(
    private val totalCount: Int,
    private val manualLottoGenerators: List<ManualLottoGenerator>
) {

    init {
        require(totalCount >= manualLottoGenerators.size) {
            "수동 구매 개수가 총 구매 개수보다 큽니다. 구매 금액: $totalCount, 수동 구매 개수: $manualLottoGenerators.size"
        }
    }

    constructor(purchase: Money) : this(purchase, listOf())

    constructor(
        purchase: Money,
        manualLottoGenerators: List<ManualLottoGenerator>
    ) : this((purchase / Lotto.PRICE).toInt(), manualLottoGenerators)

    fun create(): Lottos {
        val manualCount = manualLottoGenerators.size
        val randomCount = totalCount - manualCount

        val randomLottoGenerators = (1..randomCount).map { RandomLottoGenerator }
        val lottoGenerators = manualLottoGenerators.plus(randomLottoGenerators)

        return Lottos(lottoGenerators.map { it.generate() })
    }
}
