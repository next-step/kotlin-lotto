package lotto.domain

internal data class Lotto(val lottoNums: List<LottoNum>) {

    init {
        require(this.lottoNums.size == NUM_SIZE) {
            "the number of nums must be $NUM_SIZE"
        }
        require(this.lottoNums.distinct().size == NUM_SIZE) {
            "all of nums must be unique"
        }
    }

    internal fun findMatchNums(lotto: Lotto): List<LottoNum> {
        return lotto.lottoNums.filter(this.lottoNums::contains)
    }

    internal fun matchNum(lottoNum: LottoNum): Boolean {
        return this.lottoNums.contains(lottoNum)
    }

    companion object {
        const val NUM_SIZE = 6
    }
}
