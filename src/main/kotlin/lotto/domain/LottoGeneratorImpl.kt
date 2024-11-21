package lotto.domain

class LottoGeneratorImpl : LottoGenerator {

    override fun generate(): Lotto {
        val numbers = (1..45).shuffled()
            .take(6)
            .sorted()
        return Lotto(numbers = numbers)
    }
}
