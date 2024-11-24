package lotto.domain

class LottoGeneratorImpl : LottoGenerator {

    override fun generate(): Lotto {
        val numbers = LottoGenerator.RANGE.shuffled()
            .take(6)
            .sorted()
        return Lotto(numbers = numbers)
    }
}
