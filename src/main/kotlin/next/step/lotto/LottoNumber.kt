package next.step.lotto

@JvmInline
value class LottoNumber(private val n: Int) {
    init {
        require(n in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "로또 번호는 1~45 사이여야 합니다." }
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        fun of(n: Int): LottoNumber {
            return LottoNumber(n)
        }
    }
}