package lotto.model

private val LOTTO_ALL_NUMBER = (1..45).map { LottoNumber(it) }.toList()

class RandomLottoNumberGenerator : LottoNumberGenerator {

    override fun pick(): LottoNumbers =
        LottoNumbers(
            LOTTO_ALL_NUMBER.shuffled().subList(0, 6)
                .sortedBy { it.number }
        )
}
