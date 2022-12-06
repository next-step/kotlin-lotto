package lotto.model

data class LottoNumber(val value: Int) {
    init {
        require(value in 1..46)
    }

    companion object {
        fun of(input: String): LottoNumber {
            return LottoNumber(input.toInt())
        }
    }
}
