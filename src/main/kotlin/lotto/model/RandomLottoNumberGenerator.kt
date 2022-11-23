package lotto.model

private val LOTTO_ALL_NUMBER = (1..45).toList()

class RandomLottoNumberGenerator : LottoNumberGenerator {

    override fun pick(): List<LottoNumber> =
        LOTTO_ALL_NUMBER.shuffled().subList(0, 6)
            .map { LottoNumber(it) }
            .sortedBy { it.number }
}
