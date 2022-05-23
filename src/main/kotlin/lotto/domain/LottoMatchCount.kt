package lotto.domain

data class LottoMatchCount(val number: Int) {

    init {
        require(number in MIN_MATCH_COUNT..MAX_MATCH_COUNT) {
            "로또 일치 개수는 $MIN_MATCH_COUNT 와 $MAX_MATCH_COUNT 사이여야 합니다. (입력:$number)"
        }
    }

    companion object {
        private const val MIN_MATCH_COUNT = 0
        private const val MAX_MATCH_COUNT = 6

        fun listOf(vararg numbers: Int): List<LottoMatchCount> {
            return numbers.map(::LottoMatchCount)
        }
    }
}
