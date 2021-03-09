package lotto.domain

internal data class Lotto(val lottoNums: LottoNums) {
    constructor(nums: List<Int>) : this(LottoNums(nums.map { LottoNum.of(it) }))

    internal fun findMatchedNums(source: Lotto): List<LottoNum> {
        return source.lottoNums.findMatchNums(this.lottoNums)
    }
}
