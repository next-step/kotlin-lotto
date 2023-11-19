package lotto.domain

class LottoNumbers(private val numbers: List<Int>) {
    init {
        validateNumbersCount()
        validateDistinctNumbers()
        validateNumberRange()
    }

    val readOnlyNumbers: List<Int> = numbers.toList()

    private fun validateNumbersCount() {
        require(numbers.size == LottoConstants.NUMBERS_PER_TICKET) {
            "번호는 정확히 ${LottoConstants.NUMBERS_PER_TICKET}개 이어야 합니다."
        }
    }

    private fun validateDistinctNumbers() {
        require(numbers.distinct().size == numbers.size) {
            "번호는 모두 달라야 합니다."
        }
    }

    private fun validateNumberRange() {
        require(numbers.all { it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END }) {
            "번호는 ${LottoConstants.NUMBER_RANGE_START}에서 ${LottoConstants.NUMBER_RANGE_END} 범위 내에 있어야 합니다."
        }
    }
}
