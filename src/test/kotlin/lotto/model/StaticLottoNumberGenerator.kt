package lotto.model

class StaticLottoNumberGenerator(private val number: List<Int>) : LottoNumberGenerator {
    override fun pick(): LottoNumbers = LottoNumbers(number.map { LottoNumber.valueOf(it) })
}
