package lotto.util

class LottoNumberGenerator {
    companion object{
        fun generateNumbers(): Set<Int> {
            return (1..45).shuffled()
                .subList(0, 6).toSet()
        }
    }
}