package lotto

private const val SIZE = 6

class WinningNumber(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE)
    }

    fun match(lotto: Lotto): LottoMatch {
        val matchCount = numbers.count { lotto.contains(it) }

        return LottoMatch.of(matchCount)
    }
}
