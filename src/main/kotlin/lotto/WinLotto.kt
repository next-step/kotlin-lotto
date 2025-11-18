package lotto

class WinLotto {
    val winLotto: Lotto

    constructor(input: String?) {
        if (input.isNullOrBlank()) throw IllegalArgumentException("뭐라도 입력하세요")

        val splitted = splitToSix(input)

        splitted.forEach { if (!it.matches("^\\d+$".toRegex())) throw IllegalArgumentException("올바른 숫자를 입력하세요") }

        val numbers = splitted.map { it.toInt() }
        this.winLotto = Lotto(numbers)
    }

    private fun splitToSix(input: String): List<String> {
        val splitted = input.trim().split(" ")
        if (splitted.distinct().size != 6) {
            throw IllegalArgumentException("6개의 서로 다른 숫자를 입력하세요")
        }
        return splitted
    }

    fun matchCount(lotto: Lotto): Int {
        return winLotto.numbers.intersect(lotto.numbers.toSet()).size
    }
}
