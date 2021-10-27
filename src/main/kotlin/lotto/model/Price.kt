package lotto.model

/**
 * 구앱 금액 및 로또 생성 개수 관리 클래스
 * */
data class Price(
    val value: Int?
) {
    init {
        require(value != null && value >= MIN_PRICE) { EXCEPTION_PRICE_NULL }
        require(value % MIN_PRICE == 0) { EXCEPTION_PRICE_FORMAT }
    }

    val lottoCount: Int = value?.div(MIN_PRICE) ?: DEFAULT_LOTTO_COUNT

    companion object {
        private const val DEFAULT_LOTTO_COUNT = 0
        private const val MIN_PRICE = 1000
        const val EXCEPTION_PRICE_NULL = ""
        const val EXCEPTION_PRICE_FORMAT = ""
    }
}
