package lotto.domain

object LottoNumbers {
    private const val LOTTO_SIZE = 6
    private val LOTTO_NUMBER_RANGE = 1..45
    private val numbers = (LOTTO_NUMBER_RANGE).toSet()

    private val lottoNumbers = numbers.map { LottoNumber(it) }.toSet()

    fun makeRandomLottoNumbers(): Set<LottoNumber> {
        return lottoNumbers.shuffled().take(LOTTO_SIZE).toSet()
    }
}
