package lotto.domain

object DuplicateFreeSequenceGenerator {
    fun generate(from: Int, to: Int, count: Int): List<Int> {
        return (from..to).shuffled().take(count)
    }
}
