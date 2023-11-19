package lotto.domain

class LottoProperties(
    val lottoPrice: Int = DEFAULT_LOTTO_PRICE,
) {
    companion object {
        private const val DEFAULT_LOTTO_PRICE = 1_000
    }
}
