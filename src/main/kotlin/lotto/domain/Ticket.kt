package lotto.domain

data class Ticket(
    private val purchasePrice: Money,
    val manualLottoNumbers: List<Set<Int>>
) {
    val autoLottoSize = autoLottoSize()
    val manualLottoSize = manualLottoSize()

    private fun autoLottoSize() = (purchasePrice / Money(LOTTO_PRICE)).toInt() - manualLottoSize()

    private fun manualLottoSize() = manualLottoNumbers.size

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
