package lotto.domain

object LottoNumbersGeneratorStub : LottoNumbersGenerator {
    override fun generate(count: Int): List<LottoNumber> {
        return listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
    }
}
