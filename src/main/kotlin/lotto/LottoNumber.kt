package lotto

@JvmInline
value class LottoNumber(val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in LOTTO_NUMBERS_POOL) {
            "로또 번호는 1부터 45까지만 허용합니다"
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        private val LOTTO_NUMBERS_POOL = (1..45)
    }
}
