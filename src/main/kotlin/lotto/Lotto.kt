package lotto

@JvmInline
value class Lotto private constructor(val numbers: List<Int>) {
    companion object {
        fun of(numbers: List<Int>): Lotto {
            require(numbers.size == 6) { "로또 숫자의 개수는 6이어야 합니다" }

            return Lotto(numbers)
        }
    }
}
