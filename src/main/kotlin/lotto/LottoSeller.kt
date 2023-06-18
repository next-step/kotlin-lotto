package lotto

class LottoSeller {
    fun sell(totalPurchasePrice: Int): Int {
        require(totalPurchasePrice > 0) { "총 구매금액은 0 보다 커야합니다" }
        return totalPurchasePrice / LOTTO_PRICE
    }

    companion object {
        // LOTTO_PRICE 는 생성시에 외부에서 주입받는게 더 좋을까요??
        private const val LOTTO_PRICE = 1_000
    }
}
