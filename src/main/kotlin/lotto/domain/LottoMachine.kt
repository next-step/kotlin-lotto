package lotto.domain

object LottoMachine : LottoGenerator {
    override fun generateLotto(): Lotto {
        val lottoNumbers = LottoNumber.NUMBERS
            .keys
            .shuffled()
            .take(Lotto.COUNT)

        return generateLotto(lottoNumbers)
    }

    override fun generateLotto(numbers: List<Int>): Lotto {
        val lottoNumbers = numbers.map { number -> LottoNumber.from(number) }
            .toSet()

        return Lotto(lottoNumbers)
    }
}
