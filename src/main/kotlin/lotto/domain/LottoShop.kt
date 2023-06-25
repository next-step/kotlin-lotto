package lotto.domain

import lotto.domain.response.LottosGenerateRequest
import lotto.domain.response.LottosGenerateResponse

object LottoShop {
    fun sellByMoneyWithManualLottos(
        request: LottosGenerateRequest,
    ): LottosGenerateResponse {
        val manualLottos = createManualLottos(request.manualLottoNumbers)
        val autoLottos = createAutoLottos(request.money - manualLottos.totalCost)

        return LottosGenerateResponse(manualLottos, autoLottos)
    }

    private fun createManualLottos(manualLottoNumbers: List<LottoNumbers>): Lottos =
        LottoType.MANUAL.generate(
            lottoQuantity = manualLottoNumbers.lottoQuantity(),
            lottoNumbers = manualLottoNumbers,
        )

    private fun createAutoLottos(money: Money): Lottos =
        LottoType.AUTO.generate(
            lottoQuantity = getLottoQuantity(money),
        )

    private fun getLottoQuantity(money: Money): LottoQuantity {
        return LottoQuantity(money.value / Lotto.PRICE)
    }

    private fun List<LottoNumbers>.lottoQuantity() = LottoQuantity(size)
}
