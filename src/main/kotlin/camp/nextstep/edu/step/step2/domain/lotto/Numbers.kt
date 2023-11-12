package camp.nextstep.edu.step.step2.domain.lotto

@JvmInline
value class Numbers(
    private val numbers: List<Number>
) {

    init {
        require(numbers.size == numbers.distinct().size) { "로또 번호는 중복될 수 없습니다." }
    }

    fun getNumberElements(): List<Int> {
        return numbers.map { it.getNumber() }
    }

    fun countMatch(targetNumbers: Numbers): Int {
        return numbers.count { targetNumbers.getNumberElements().contains(it.getNumber()) }
    }

    companion object {
        fun ofNumbers(numbers: List<Number>): Numbers {
            return Numbers(numbers)
        }

        fun ofInputValues(numbers: String): Numbers {
            val numberList = numbers.split(",")
                .map { it.trim() }
                .map { Number.of(it.toInt()) }
            return Numbers(numberList)
        }

        /**
         * @description : 로또 번호를 생성한다.
         */
        fun createNumbers(): List<Number> {
            val numbers = (START_NUMBER..END_NUMBER)
                .shuffled()
                .subList(0, NUMBER_SIZE)
                .sorted()

            return numbers.map { Number.of(it) }
        }

        private const val NUMBER_SIZE = 6
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
    }

}
