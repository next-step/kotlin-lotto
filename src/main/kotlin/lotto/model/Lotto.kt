package lotto.model

data class Lotto(var numbers: MutableList<Int>) {
    fun add(number: Int) {
        if (numbers.none { it == number }) {
            numbers.add(number)
        }
    }
}
