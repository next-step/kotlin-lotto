package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MINIMUM..MAXIMUM) {
            "${MINIMUM}부터 ${MAXIMUM}까지의 숫자를 입력하세요"
        }
    }

    companion object {
        const val MINIMUM = 1
        const val MAXIMUM = 45
    }
}
