package lotto.domain

class LottoCustomerInput(
    val purchasePrice: Int,
    val selectLottosNumbers: List<LottoNumbers> = listOf(),
) {
    fun getLottoAutoCount() = purchasePrice.div(Lotto.PRICE) - selectLottosNumbers.size

    fun getLottoSelectCount() = selectLottosNumbers.size
}
