package lotto.domain

fun interface LottoNumberGenerator {
    fun generate(): Set<Int>
}

class AutoLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): Set<Int> {
        return (1..45).shuffled().take(6).toSet()
    }
}
