package lotto.domain


object LottoNumberGenerator {
    fun generate(): List<Int> {
        return generateSequence {
            (1..45).random()
        }.distinct().take(6).toList()
    }
}
