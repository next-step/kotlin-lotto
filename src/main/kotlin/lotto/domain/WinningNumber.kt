package lotto.domain

class WinningNumber(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == SIZE) { "당첨번호는 중복없는 6개의 번호를 가져야 합니다." }
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber.from(it) }.toSet())

    fun match(lottos: List<Lotto>): LottoResult {
        return LottoResult(lottos.map { match(it) })
    }

    private fun match(lotto: Lotto): LottoRank {
        val matchCount = numbers.count { lotto.contains(it) }

        return LottoRank.of(matchCount)
    }

    companion object {
        const val SIZE = 6
    }
}
