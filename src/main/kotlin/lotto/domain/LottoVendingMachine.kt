package lotto.domain

object LottoVendingMachine {
    private const val LOTTO_SIZE = 6
    private val lottoNumbers = (1..45).map { LottoNumber(it) }.toSet()

    fun makeRandomLottoNumbers(): Set<LottoNumber> {
        return lottoNumbers.shuffled().take(LOTTO_SIZE).toSet()
    }
    fun buy(numberOfLotto: Int): List<LottoNumbers> {
        return List(numberOfLotto) { LottoNumbers.createRandom() }
    }
}
