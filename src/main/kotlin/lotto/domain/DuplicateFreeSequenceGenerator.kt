package lotto.domain

object DuplicateFreeSequenceGenerator {
    fun generate(from: Int, to: Int, count: Int): Set<Int> {
        return (from..to).shuffled().take(count).toSet()
    }
}
