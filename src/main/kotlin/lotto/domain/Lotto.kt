package lotto.domain

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
}
