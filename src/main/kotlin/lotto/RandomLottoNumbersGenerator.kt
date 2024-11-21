package lotto

class RandomLottoNumbersGenerator : LottoNumbersGenerator {
    override fun generate(): Set<Int> {
        return (1..45).shuffled().take(6).toSet()
    }
}
