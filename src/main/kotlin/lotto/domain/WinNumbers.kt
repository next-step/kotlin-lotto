package lotto.domain

@JvmInline
value class WinNumbers(val value: List<LottoNumber>) {

    init {
        require(value.toSet().size == value.size) { "중복된 숫자가 있습니다" }
    }

    fun matchCount(lotto: Lotto): Int = value.count { lotto.numbers.contains(it) }

    companion object {
        fun of(numbers: List<Int>): WinNumbers = WinNumbers(numbers.map(::LottoNumber))
    }
}
