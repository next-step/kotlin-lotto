package lotto.domain

class LottoCustomerInput(
    val purchasePrice: Int,
    val selectLottosNumbers: List<LottoNumbers> = listOf(),
) {
    init {
        require(purchasePrice >= 1000) { "한장 이상 구매하세요" }
        require(selectLottosNumbers.size <= purchasePrice.div(Lotto.PRICE)) { "수동 구매 갯수가 구매 갯수보다 많아요" }
    }

    fun getLottoAutoCount() = purchasePrice.div(Lotto.PRICE) - selectLottosNumbers.size

    fun getLottoSelectCount() = selectLottosNumbers.size
}
