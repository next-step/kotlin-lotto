package lotto.vo

@JvmInline
value class LottoNumber(
    val value: Int,
) : Comparable<LottoNumber> {
    init {
        require(value in 1..45) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    override fun compareTo(other: LottoNumber): Int {
        return value - other.value
    }
}
