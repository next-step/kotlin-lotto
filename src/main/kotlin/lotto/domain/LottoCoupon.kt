package lotto.domain

data class LottoCoupon(
    private val lotto: Lotto
) {
    val toLotto: Lotto = lotto.copy()

    companion object {
        fun of(numbers: Collection<Int>): LottoCoupon {
            return LottoCoupon(Lotto.of(numbers))
        }
    }
}
