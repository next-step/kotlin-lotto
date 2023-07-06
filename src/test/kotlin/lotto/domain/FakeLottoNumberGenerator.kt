package lotto.domain

class FakeLottoNumberGenerator(
    private val list: List<LottoNumber> = (1..6).map { LottoNumber(it) }
) : LottoNumberGenerator {
    override fun generate(): List<LottoNumber> {
        return list
    }
}
