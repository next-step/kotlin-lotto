package lotto.domain

internal data class LottoNums(private val nums: List<LottoNum>) {

    init {
        require(this.nums.size == NUM_SIZE) {
            "the number of nums must be $NUM_SIZE"
        }
        require(this.nums.distinct().size == NUM_SIZE) {
            "all of nums must be unique"
        }
    }

    constructor(vararg nums: Int) : this(nums = nums.asList().map { LottoNum(it) })

    internal fun findMatchNums(lottoNums: LottoNums): List<LottoNum> {
        return lottoNums.nums.filter(this.nums::contains)
    }

    companion object {
        const val NUM_SIZE = 6
    }
}
