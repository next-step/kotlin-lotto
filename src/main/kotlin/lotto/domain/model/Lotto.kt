package lotto.domain.model

class Lotto(numbers: List<Int> = emptyList()) {

    val numbers: List<Int> = initList(numbers)

    override fun toString(): String {
        return numbers.toString()
    }

    private fun initList(numbers: List<Int>): List<Int> {
        if (numbers.isEmpty()) {
            return LOTTO_NUMBER_RANGE.shuffled().subList(START_LOTTO_INDEX, LAST_LOTTO_INDEX).sorted()
        }

        check(numbers.size == LAST_LOTTO_INDEX) { "로또는 숫자 6개로 구성되어야 합니다" }

        repeat(numbers.size) { index ->
            check(LOTTO_NUMBER_RANGE.contains(numbers[index])) { "로또는 1부터 45 사이의 숫자로 구성되어야 합니다" }
        }

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

    companion object {
        const val START_LOTTO_INDEX = 0
        const val LAST_LOTTO_INDEX = 6
        val LOTTO_NUMBER_RANGE = (1..45)
    }
}
