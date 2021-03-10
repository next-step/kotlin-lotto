package lotto.domain

internal data class LottoNum constructor(val value: Int) {

    init {
        require(this.value in MIN_NUM..MAX_NUM) {
            "lotto nums are from $MIN_NUM to $MAX_NUM"
        }
    }

    companion object {
        const val MIN_NUM = 1
        const val MAX_NUM = 45
        private val CACHE = (MIN_NUM..MAX_NUM).map { it to LottoNum(it) }.toMap()

        fun from(num: Int): LottoNum {
            return CACHE[num] ?: LottoNum(num)
        }
    }
}
