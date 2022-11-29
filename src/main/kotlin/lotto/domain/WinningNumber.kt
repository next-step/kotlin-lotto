package lotto.domain

class WinningNumber(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE)
    }

    fun match(lotto: Lotto): LottoMatch {
        val matchCount = numbers.count { lotto.contains(it) }

        return LottoMatch.of(matchCount)
    }

    companion object {
        const val SIZE = 6
    }
}
