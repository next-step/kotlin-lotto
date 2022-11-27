package simulator.lotto

class Lotto(numbers: Set<Int>) {
    val numbers: Set<Int>

    init {
        require(numbers.size == NUMBERS_COUNT) {
            "로또 번호는 ${NUMBERS_COUNT}개의 숫자로 구성되어야 합니다"
        }

        require(numbers.maxOf { it } <= MAX_NUMBER) {
            "로또 번호는 ${MAX_NUMBER}이하이어야 합니다"
        }

        require(numbers.minOf { it } >= MIN_NUMBER) {
            "로또 번호는 ${MIN_NUMBER}이상이어야 합니다"
        }

        this.numbers = numbers.toSortedSet()
    }

    fun match(lotto: Lotto): Int {
        var matches = 0
        lotto.numbers.forEach {
            if (numbers.contains(it)) matches++
        }
        return matches
    }

    override fun toString(): String {
        return numbers.joinToString(",")
    }

    companion object {
        const val PRICE = 1000
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBERS_COUNT = 6
    }
}
