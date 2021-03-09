package lotto.domain

internal data class LottoNum private constructor(val value: Int) {

    companion object {
        const val MIN_NUM = 1
        const val MAX_NUM = 45
        private val NUMS = (MIN_NUM..MAX_NUM)
        private val CACHE = NUMS.map(::LottoNum)

        fun of(num: Int): LottoNum {
            require(NUMS.contains(num)) {
                "lotto nums are from $MIN_NUM to $MAX_NUM"
            }
            val index = num - 1
            return CACHE[index]
        }
    }
}
