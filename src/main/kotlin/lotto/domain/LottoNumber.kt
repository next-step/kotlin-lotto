package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER) {
            "로또 번호는 항상 ${Lotto.MIN_NUMBER}에서 ${Lotto.MAX_NUMBER}사이 값이어야 합니다."
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return value.compareTo(other.value)
    }
}
