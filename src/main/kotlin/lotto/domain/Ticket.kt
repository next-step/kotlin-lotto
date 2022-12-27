package lotto.domain

data class Ticket(
    private val purchasePrice: Int,
    val selectedLottoNumbers: List<Set<LottoNumber>>
) {
    val autoLottoSize = autoLottoSize()
    val manualLottoSize = manualLottoSize()

    private fun autoLottoSize() = (purchasePrice / LOTTO_PRICE) - manualLottoSize()

    private fun manualLottoSize() = selectedLottoNumbers.size

    companion object {
        const val LOTTO_PRICE = 1000
    }
}