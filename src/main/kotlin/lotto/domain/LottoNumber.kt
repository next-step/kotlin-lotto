package lotto.domain

data class LottoNumber(val value: Int) : Comparable<LottoNumber> {

    init {
        require(value in NUMBER_RANGE) { "로또 번호는 $NUMBER_RANGE 범위 내의 숫자여야 합니다." }
    }

    override fun compareTo(other: LottoNumber): Int = value.compareTo(other.value)

    companion object {
        val NUMBER_RANGE = 1..45
    }
}
