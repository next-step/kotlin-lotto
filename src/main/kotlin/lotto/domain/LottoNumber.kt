package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) {
            "로또 번호는 항상 ${MIN_NUMBER}에서 ${MAX_NUMBER}사이 값이어야 합니다."
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return value.compareTo(other.value)
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
