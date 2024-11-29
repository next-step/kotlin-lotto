package lotto

@JvmInline
value class LottoNumber(val value: Int) {
    companion object {
        fun generate(value: Int): LottoNumber {
            return LottoNumber(value)
        }
    }
}
