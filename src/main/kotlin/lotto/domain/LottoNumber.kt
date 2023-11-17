package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in validNumberRange) { "Invalid number: number not in 1..45" }
    }

    companion object {
        val validNumberRange = 1..45
    }
}
