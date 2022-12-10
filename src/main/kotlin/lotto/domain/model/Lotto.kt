package lotto.domain.model

class Lotto(numbers: List<LottoNumber> = emptyList()) {

    val numbers: List<LottoNumber> = initList(numbers)

    override fun toString(): String {
        return "[${numbers.joinToString(", ") { lottoNumber -> "${lottoNumber.number}" }}]"
    }

    private fun initList(numbers: List<LottoNumber>): List<LottoNumber> {
        if (numbers.isEmpty()) {
            return LottoNumber.LOTTO_NUMBER_RANGE
                .shuffled()
                .subList(START_LOTTO_INDEX, LAST_LOTTO_INDEX)
                .sorted()
                .map { number ->
                    LottoNumber(number)
                }
        }

        check(numbers.size == LAST_LOTTO_INDEX) { "로또는 숫자 6개로 구성되어야 합니다" }

        repeat(numbers.size) {
            check(
                numbers
                    .groupingBy {
                        it
                    }
                    .eachCount()
                    .filter {
                        it.value > 1
                    }
                    .isEmpty()
            ) { "로또는 중복되지 않는 숫자로 구성되어야 합니다" }
        }

        return numbers
    }

    fun contains(winningNumber: Int): Boolean {
        return numbers.map { it.number }.contains(winningNumber)
    }

    companion object {
        const val START_LOTTO_INDEX = 0
        const val LAST_LOTTO_INDEX = 6
    }
}
