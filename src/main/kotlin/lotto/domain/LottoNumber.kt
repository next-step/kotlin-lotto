package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in 1..45) { "Invalid number: number not in 1..45" }
    }
}
