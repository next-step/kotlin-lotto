package additionCalculator

class StringAddCalculator {
    fun add(tokens: List<String>): Int =
        tokens.toIntList().validatePositive().sum()

    private fun List<Int>.validatePositive(): List<Int> = map {
        require(it >= 0) { "음수는 계산할 수 없습니다." }
        it
    }

    private fun List<String>.toIntList() = map { it.toInt() }
}
