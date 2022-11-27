package lotto.domain

object LottoMachine : LottoGenerator {
    override fun generateLottoNumbers(): Set<LottoNumber> =
        LottoNumber.NUMBERS
            .values
            .shuffled()
            .take(Lotto.COUNT)
            .toSet()

    override fun generateLotto(numbers: List<Int>): Lotto {
        val lottoNumbers = numbers.map { number -> LottoNumber.from(number) }
            .toSet()

        return Lotto(lottoNumbers)
    }
}
