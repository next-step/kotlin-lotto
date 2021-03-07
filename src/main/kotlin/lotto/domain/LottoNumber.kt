package lotto.domain

data class LottoNumber(val value: Int) {
    init {
        require(value in LOTTO_NUMBER_RANGE) {
            String.format(
                "로또 넘버의 범위는 %s ~ %s 입니다. 입력 값: %s",
                MINIMUM_VALUE,
                MAXIMUM_VALUE,
                value
            )
        }
    }

    companion object {
        private const val MINIMUM_VALUE = 1
        private const val MAXIMUM_VALUE = 45
        val LOTTO_NUMBER_RANGE = (MINIMUM_VALUE..MAXIMUM_VALUE)
    }
}
