package lotto.core

import lotto.core.constant.LottoConstants

object LottoMarket {
    fun purchase(
        purchaseAmount: LottoPurchaseCount,
        manualLottoNumbers: List<List<LottoNumber>>,
    ): Lottos {
        val lottos = issueLottos(purchaseAmount, manualLottoNumbers)
        return Lottos(lottos)
    }

    private fun issueLottos(
        purchaseAmount: LottoPurchaseCount,
        manualLottoNumbers: List<List<LottoNumber>>,
    ): List<Lotto> {
        val manualLottos = manualLottoNumbers.indices.map { Lotto(manualLottoNumbers[it]) }
        val autoLottos = List(purchaseAmount.autoLottoCount) { Lotto(generateNumbers()) }

        return manualLottos + autoLottos
    }

    private fun generateNumbers(): List<LottoNumber> =
        (LottoNumber.LOTTO_NUMBER_MIN..LottoNumber.LOTTO_NUMBER_MAX).map { LottoNumber(it) }
            .shuffled()
            .take(LottoConstants.LOTTO_NUMBER_COUNT)
            .sortedBy { it.number }
}
