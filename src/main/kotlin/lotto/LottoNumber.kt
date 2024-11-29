package lotto

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in LOTTO_RANGE) { "로또 번호는 1부터 45까지 가능합니다. input = $value" }
    }

    companion object {
        private val LOTTO_RANGE = 1..45

        fun generate(value: Int): LottoNumber {
            return LottoNumber(value)
        }
    }
}
