package lotto

@JvmInline
value class Lotto(val numbers: List<Int>) {
    companion object {
        fun of(numbers: List<Int>): Lotto {
            return Lotto(numbers)
        }
    }
}
