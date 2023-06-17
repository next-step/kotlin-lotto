package lotto.domain

object LottoNumberGenerator {
    fun generate(): List<Int> {
        return (1..45).shuffled().subList(0, 6)
    }
}
