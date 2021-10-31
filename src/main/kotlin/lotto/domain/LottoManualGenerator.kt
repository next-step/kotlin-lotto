package lotto.domain

class LottoManualGenerator(
    val purchaseInformation: PurchaseInformation
) {
    fun generateLottos(): List<Lotto> {
        return purchaseInformation.textLottos
            .map { ManualNumberGenerator.generateNumbers(it) }
            .map { Lotto(it) }
    }
}
