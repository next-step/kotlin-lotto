package lotto.domain

class RandomLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        val numbers = (1..45).shuffled().take(6).toSet()
        return Lotto(numbers)
    }
}
