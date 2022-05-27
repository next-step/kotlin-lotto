package lotto.auto.domain

class Lotto(private val numbers: List<Int>) {

    fun match(other: Lotto): Int = numbers.count(other.numbers::contains)
}
