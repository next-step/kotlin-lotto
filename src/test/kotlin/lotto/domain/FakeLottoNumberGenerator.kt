package lotto.domain

class FakeLottoNumberGenerator(
    private val numbers: List<Int>,
) : LottoNumberGenerator {
    override fun generateNumbers(): List<LottoNumber> {
        return numbers.map(::LottoNumber)
    }
}
