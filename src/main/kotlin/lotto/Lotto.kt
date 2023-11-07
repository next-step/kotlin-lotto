package lotto

class Lotto(private vararg val numbers: Int) {

    init {
        require(numbers.distinct().size == 6) { "로또는 유일한 숫자 6개로 구성해야합니다." }
    }

    fun matchedCount(other: Lotto): Int {
        return numbers.filter { it in other.numbers }.size
    }
}
