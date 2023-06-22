package lotto.domain

object DuplicateFreeSequenceGenerator {
    operator fun invoke(from: Int, to: Int, count: Int): List<Int> {
        return (from..to).shuffled()
            .take(count)
    }
}
