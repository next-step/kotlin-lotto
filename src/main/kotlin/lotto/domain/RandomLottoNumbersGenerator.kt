package lotto.domain

object RandomLottoNumbersGenerator : LottoNumbersGenerator {
    override fun generate(count: Int): List<LottoNumber> {
        return (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE)
            .shuffled()
            .take(count)
            .sorted()
            .map { LottoNumber.of(it) }
    }

}
