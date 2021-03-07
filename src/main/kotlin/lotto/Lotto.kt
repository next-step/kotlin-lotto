package lotto

internal data class Lotto(private val lottoNums: LottoNums) {
    constructor(vararg nums: Int) : this(LottoNums(*nums))

    internal fun matchCount(source: Lotto): List<LottoNum> {
        return source.lottoNums.matchNums(source.lottoNums)
    }
}
