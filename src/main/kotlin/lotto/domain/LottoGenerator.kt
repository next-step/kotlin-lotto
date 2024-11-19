package lotto.domain

class LottoGenerator {
    fun generate(): List<Int> {
        return (1..45).shuffled()
            .take(6)
            .sorted()
    }
}
