package lotto.domain

@JvmInline
value class Amount(private val value: Int) {
    init {
        require(value >= LottoStore.LOTTO_PRICE) { "구입 금액은 최소 ${LottoStore.LOTTO_PRICE}원 이상이어야 합니다." }
    }

    fun calculateLottoCount(): Int {
        return value / LottoStore.LOTTO_PRICE
    }
}
