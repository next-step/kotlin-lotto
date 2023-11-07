package lotto

class Lotto(private vararg val numbers: Int) {

    init {
        require(numbers.size == 6) { "로또의 숫자 갯수는 6개만 가능합니다." }
    }

    fun matchedCount(other: Lotto): Int {
        return numbers.filter { it in other.numbers }.size
    }
}
