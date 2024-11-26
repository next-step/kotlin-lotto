package lotto

@JvmInline
value class LottoNumber(private val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) {
            "로또는 ${MIN_NUMBER}-${MAX_NUMBER} 범위의 숫자로 이루어져야 합니다. 입력값: $value"
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.value - other.value
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
