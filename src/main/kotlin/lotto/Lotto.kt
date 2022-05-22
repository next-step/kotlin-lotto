package lotto

@JvmInline
value class Lotto private constructor(val numbers: List<Int>) {
    companion object {
        private const val NUMBER_COUNT = 6

        fun of(numbers: List<Int>): Lotto {
            require(numbers.size == NUMBER_COUNT) { "로또 숫자의 개수는 $NUMBER_COUNT 이어야 합니다" }

            return Lotto(numbers)
        }
    }
}
