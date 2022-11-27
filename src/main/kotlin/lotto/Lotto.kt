package lotto

data class Lotto(val numbers: List<Int>) {

    val value = Lotto.value

    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    companion object {
        val value = Value(1000)
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
