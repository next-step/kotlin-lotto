package lotto

data class LottoNumber(val number: Int) {
    init {
        require(number in MINIMUM..MAXIMUM) {
            "${MINIMUM}부터 ${MAXIMUM}까지의 숫자를 입력하세요"
        }
    }

    constructor(number: String) : this(number.toInt())

    companion object {
        const val MINIMUM = 1
        const val MAXIMUM = 45
    }
}
