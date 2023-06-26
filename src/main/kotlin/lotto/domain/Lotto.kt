package lotto.domain

class Lotto(numbers: List<Int>) {
    val numbers: Set<Int> = numbers.toSet()
    override fun toString(): String {
        return numbers.joinToString(
            prefix = "[",
            postfix = "]",
            separator = ", ",
        )
    }
}
