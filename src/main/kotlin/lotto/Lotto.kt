package lotto

class Lotto(private vararg val numbers: Int) {

    fun matchedCount(other: Lotto): Int {
        return numbers.filter { it in other.numbers }.size
    }
}
