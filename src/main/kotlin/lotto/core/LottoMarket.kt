package lotto.core

import lotto.core.constant.LottoConstants

object LottoMarket {
    fun purchase(
        purchaseAmount: String,
        manualLottoNumbers: List<List<LottoNumber>>,
    ): Lottos {
        val purchasableCount = calculatePurchasableCount(purchaseAmount)
        val lottos = issueLottos(purchasableCount, manualLottoNumbers)
        return Lottos(lottos)
    }

    private fun calculatePurchasableCount(purchaseAmount: String): Int {
        val amount = purchaseAmount.toIntOrNull() ?: throw IllegalArgumentException("잘못된 금액이 입력되었습니다.")
        return amount / LottoConstants.LOTTO_PRICE
    }

    private fun issueLottos(
        totalCount: Int,
        manualLottoNumbers: List<List<LottoNumber>>,
    ): List<Lotto> {
        require(totalCount >= manualLottoNumbers.size) { "수동 로또 개수가 잘못입력되었습니다." }

        val manualLottos = manualLottoNumbers.indices.map { Lotto(manualLottoNumbers[it]) }
        val autoLottos = List(totalCount - manualLottos.size) { Lotto(generateNumbers()) }

        return manualLottos + autoLottos
    }

    private fun generateNumbers(): List<LottoNumber> =
        (LottoNumber.LOTTO_NUMBER_MIN..LottoNumber.LOTTO_NUMBER_MAX).map { LottoNumber(it) }
            .shuffled()
            .take(LottoConstants.LOTTO_NUMBER_COUNT)
            .sortedBy { it.number }
}
