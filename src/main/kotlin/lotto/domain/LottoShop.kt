package lotto.domain

import lotto.domain.response.GeneratedLottosResponse

object LottoShop {
    fun sellByMoneyWithManualLottos(
        money: Money,
        manualLottoNumbers: List<LottoNumbers> = emptyList(),
    ): GeneratedLottosResponse {
        validateMoneyIsEnough(money, manualLottoNumbers.lottoQuantity())

        val manualLottos = createManualLottos(manualLottoNumbers)
        val autoLottos = createAutoLottos(money - manualLottos.totalCost)

        return GeneratedLottosResponse(manualLottos, autoLottos)
    }

    private fun createManualLottos(manualLottoNumbers: List<LottoNumbers>): Lottos =
        Lottos.from(manualLottoNumbers.map { Lotto(it) })

    private fun createAutoLottos(money: Money): Lottos =
        Lottos.random(getLottoQuantity(money))

    private fun getLottoQuantity(money: Money): LottoQuantity {
        return LottoQuantity(money.value / Lotto.PRICE)
    }

    private fun validateMoneyIsEnough(money: Money, desiredLottoQuantity: LottoQuantity) {
        val availableLottoQuantity = getLottoQuantity(money)
        require(availableLottoQuantity >= desiredLottoQuantity) {
            "금액이 부족합니다."
        }
    }

    private fun List<LottoNumbers>.lottoQuantity() = LottoQuantity(size)
}
