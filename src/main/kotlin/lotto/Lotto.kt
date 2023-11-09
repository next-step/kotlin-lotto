package lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또에 적힌 숫자는 6개입니다" }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
