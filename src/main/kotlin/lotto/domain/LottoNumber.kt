package lotto.domain

data class LottoNumber(val number: Int) {
    constructor(numberStr: String) : this(numberStr.toInt())

    init {
        require(number in MIN_VALUE..MAX_VALUE) { "lotto number out of range" }
    }

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
        val RANGE = (MIN_VALUE..MAX_VALUE)
    }
}
