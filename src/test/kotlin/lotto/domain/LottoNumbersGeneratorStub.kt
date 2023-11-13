package lotto.domain

object LottoNumbersGeneratorStub : LottoNumbersGenerator {
    override fun generate(count: Int): List<LottoNumber> {
        return listOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        )
    }
}
