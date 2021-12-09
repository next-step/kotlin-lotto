package lotto.domain

class Lotto(val nums: Set<LottoNum>) {
    init {
        validateNums(nums)
    }

    private fun validateNums(numbers: Set<LottoNum>) {
        require(numbers.size == MAX_SIZE) { NUMBER_DUPLICATION_EXCEPTION_MSG }
    }

    override fun toString(): String {
        return nums.toString()
    }

    companion object {
        const val MAX_SIZE = 6
        private const val NUMBER_DUPLICATION_EXCEPTION_MSG = "로또 번호는 6개이며 중복된 숫자를 가질 수 없습니다."
        private fun makeRandomNums(): Set<LottoNum> = LottoNum.NUM_RANGE
            .map { LottoNum(it) }
            .shuffled()
            .take(MAX_SIZE)
            .sortedBy { it.num }
            .toSet()

        fun buy(): Lotto {
            return Lotto(makeRandomNums())
        }
    }
}
