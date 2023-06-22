package lotto.domain

class Lotto(val numbers: List<Int>) {
    override fun toString(): String {
        return numbers.joinToString(
            prefix = "[",
            postfix = "]",
            separator = ", ",
        )
    }
}
