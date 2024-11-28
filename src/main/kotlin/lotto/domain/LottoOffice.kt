package lotto.domain

class LottoOffice(
    private val lottoStringParser: LottoStringParser,
    private val quantityChanger: QuantityChanger,
    private val lottoGenerator: LottoGenerator,
) {

    fun purchase(amount: Int, manualLottoNumbers: List<String>): Lotties {
        val autoQuantity = quantityChanger.change(amount) - manualLottoNumbers.size
        return Lotties(
            manualLotties = createManualLotties(manualLottoNumbers),
            autoLotties = createAutoLotties(autoQuantity),
        )
    }

    private fun createManualLotties(manualLottoNumbers: List<String>): List<Lotto> {
        return manualLottoNumbers.map { lottoStringParser.parse(it) }
    }

    private fun createAutoLotties(quantity: Int): List<Lotto> {
        return List(quantity) { lottoGenerator.generate() }
    }

}
