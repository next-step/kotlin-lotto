package lottoAuto.domain

object LottoFactory {
    fun create(numOfLotto: Int): List<Lotto> {
        return List(numOfLotto) { Lotto(createShuffledLottoNumbers()) }
    }

    private fun createShuffledLottoNumbers(): LottoNumbers {
        val numbers = (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)
            .shuffled()
            .take(LottoNumbers.NUM_OF_LOTTO_NUMBERS)
            .map { LottoNumber.from(it) }
        return LottoNumbers(numbers)
    }
}
