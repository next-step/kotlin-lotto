package lottoAuto.domain

object LottoFactory {
    fun create(numOfLotto: Int): List<Lotto> {
        val randomLottoNumbers = createRandomLottoNumbers()
        return List(numOfLotto) { Lotto(randomLottoNumbers) }
    }

    private fun createRandomLottoNumbers(): LottoNumbers {
        return LottoNumbers(
            List(LottoNumbers.NUM_OF_LOTTO_NUMBERS) { LottoNumber.ofRandom() }
        )
    }
}
