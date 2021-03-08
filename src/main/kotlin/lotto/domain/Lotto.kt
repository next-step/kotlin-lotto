package lotto.domain

internal data class Lotto(val lottoNums: LottoNums) {
    constructor(vararg nums: Int) : this(LottoNums(*nums))

    internal fun findMatchedNums(source: Lotto): List<LottoNum> {
        return source.lottoNums.findMatchNums(this.lottoNums)
    }
}
