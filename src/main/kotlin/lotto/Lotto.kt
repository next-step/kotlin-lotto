package lotto

@JvmInline
value class Lotto(val numbers: List<Int>) {

    init {
        require(numbers.size == NUMBER_COUNT) { "로또 숫자의 개수는 $NUMBER_COUNT 이어야 합니다" }
    }

    companion object {
        private const val NUMBER_COUNT = 6
    }
}
