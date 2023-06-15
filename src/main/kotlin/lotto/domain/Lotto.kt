package lotto.domain

data class Lotto(val numbers: List<Int>) {
    override fun toString(): String = numbers.joinToString(", ", "[", "]")
}
