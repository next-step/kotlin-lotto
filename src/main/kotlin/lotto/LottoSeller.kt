package lotto

class LottoSeller(
    private val lottoFactory: LottoFactory
) {
    fun sell(totalPurchasePrice: Int): Lottos {
        require(totalPurchasePrice > 0) { "총 구매금액은 0 보다 커야합니다" }
        return Lottos(List(totalPurchasePrice / LOTTO_PRICE) { lottoFactory.create() })
    }

    companion object {
        // LOTTO_PRICE 는 생성시에 외부에서 주입받는게 더 좋을까요??
        private const val LOTTO_PRICE = 1_000
    }
}
