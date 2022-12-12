package lotto.domain

class WinningNumber(private val numbers: Set<LottoNumber>, private val bonusBall: LottoNumber) {
    init {
        require(numbers.size == SIZE && numbers.contains(bonusBall).not()) { "당첨번호는 중복없는 6개의 번호와 보너스볼을 가져야 합니다." }
    }

    constructor(vararg numbers: Int, bonusBall: Int) : this(
        numbers.map { LottoNumber.from(it) }.toSet(),
        bonusBall = LottoNumber.from(bonusBall)
    )

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
