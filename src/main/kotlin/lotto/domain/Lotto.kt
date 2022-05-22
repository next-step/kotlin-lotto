package lotto.domain

@JvmInline
value class Lotto(val numbers: List<Int>) {

    init {
        require(numbers.size == NUMBER_COUNT) { "로또 숫자의 개수는 $NUMBER_COUNT 이어야 합니다" }
        require(numbers.isUnique()) { "로또에 중복된 숫자가 존재할 수 없습니다" }
    }

    private fun List<Int>.isUnique(): Boolean = toSet().size == size

    companion object {
        const val NUMBER_COUNT = 6
    }
}
