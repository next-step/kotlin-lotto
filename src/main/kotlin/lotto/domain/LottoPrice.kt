package lotto.domain

@JvmInline
value class LottoPrice private constructor(
    val value: Int,
) {
    companion object {
        fun getTotalPrice(lottoCount: LottoCount): LottoPrice {
            return LottoPrice(lottoCount.multiply(Lotto.LOTTO_PRICE))
        }
    }
}
