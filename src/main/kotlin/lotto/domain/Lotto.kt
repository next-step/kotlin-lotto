package lotto.domain

class Lotto(val numbers: Set<Int>) {
    constructor(numbers: List<Int>) : this(numbers.toSet())

    override fun toString(): String {
        return numbers.joinToString(
            prefix = "[",
            postfix = "]",
            separator = ", ",
        )
    }
}
