package lotto.domain

class LottoManager(
    private val quantityChanger: QuantityChanger,
    private val lottoGenerator: LottoGenerator,
) {

    fun purchase(amount: Int): List<Lotto> {
        val quantity = quantityChanger.change(amount)
        return List(quantity) { lottoGenerator.generate() }
    }

}
