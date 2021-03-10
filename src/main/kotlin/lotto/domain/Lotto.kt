package lotto.domain

internal data class Lotto(val lottoNums: List<LottoNum>, val auto: Boolean = true) {

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

    internal fun contain(lottoNum: LottoNum): Boolean {
        return this.lottoNums.contains(lottoNum)
    }

    companion object {
        const val NUM_SIZE = 6

        fun createAutoLotto(nums: List<Int>): Lotto {
            return Lotto(nums.map { LottoNum.from(it) }, true)
        }

        fun createSelfLotto(nums: List<Int>): Lotto {
            return Lotto(nums.map { LottoNum.from(it) }, false)
        }
    }
}
