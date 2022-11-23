package lotto.model

class StaticLottoNumberGenerator(private val number: List<Int>) : LottoNumberGenerator {
    override fun pick(): List<LottoNumber> = number.map { LottoNumber(it) }
}
