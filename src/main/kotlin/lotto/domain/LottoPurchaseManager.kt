package lotto.domain

import Lottos

class LottoPurchaseManager {
    fun purchase(
        price: LottoPrice,
        manualLottos: Lottos,
    ): Lottos {
        val totalCount = price.calculatePurchaseCount()
        val autoCount = totalCount - manualLottos.size
        require(autoCount >= 0) { "수동 구매 개수가 총 구매 가능 개수를 초과했습니다." }

        val autoLottos = LottoFactory.create(autoCount)
        return Lottos(manualLottos + autoLottos)
    }
}
