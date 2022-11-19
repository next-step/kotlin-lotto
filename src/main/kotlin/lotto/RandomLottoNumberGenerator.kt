package lotto

private val LOTTO_ALL_NUMBER = (1..45).toList()

class RandomLottoNumberGenerator : LottoNumberGenerator {

    override fun pick(): List<Int> = LOTTO_ALL_NUMBER.shuffled().subList(0, 6).sorted()
}
