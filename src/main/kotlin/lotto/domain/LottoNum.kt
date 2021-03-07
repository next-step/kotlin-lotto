package lotto.domain

internal data class LottoNum(val value: Int) {
    init {
        require(NUMS.contains(value)) {
            "lotto nums are from $MIN_NUM to $MAX_NUM"
        }
    }

    companion object {
        const val MIN_NUM = 1
        const val MAX_NUM = 45
        private val NUMS = (MIN_NUM..MAX_NUM)
    }
}
