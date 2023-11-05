package lotto

class Lotto(numbers: List<Int>) {
    var numbers: List<Int>
        private set

    init {
        require(numbers.count() == NUMBER_OF_LOTTO_NUMBER)
        this.numbers = numbers.sorted()
    }

    companion object {
        const val NUMBER_OF_LOTTO_NUMBER = 6
    }
}
