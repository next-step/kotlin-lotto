package lotto.util

class LottoNumberGenerator {
    companion object{
        private fun generateNumbers(): Set<Int> {
            return (1..45).shuffled()
                .subList(0, 6).toSet()
        }

        fun generate(count: Int): List<Set<Int>> {
            return (1..count).map { generateNumbers() }
        }
    }
}
