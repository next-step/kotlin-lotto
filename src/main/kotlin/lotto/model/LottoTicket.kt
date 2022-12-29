package lotto.model

class LottoTicket(val values: List<Int>) {
    init {
        require(values.size == LOTTO_NUMBER_SIZE) { "당첨 번호는 6개여야 합니다." }
        require(values.toSet().size == LOTTO_NUMBER_SIZE) { "중복 불가" }
    }

    constructor(value: String) : this(convert(value))

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val INPUT_VALUE_DELIMITER = ", "
        private fun convert(input: String): List<Int> {
            val numbers: List<LottoNumber> = input.split(INPUT_VALUE_DELIMITER).map { LottoNumber(it) }
            return numbers.map { it.value }
        }
    }
}
