package lotto

data class Lotto(val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }
}
