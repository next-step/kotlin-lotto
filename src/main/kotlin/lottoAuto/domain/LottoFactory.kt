package lottoAuto.domain

import lottoAuto.domain.LottoNumber.Companion.toLottoNumber

object LottoFactory {
    fun create(numOfLotto: Int): List<Lotto> {
        return List(numOfLotto) { Lotto(createShuffledLottoNumbers()) }
    }

    private fun createShuffledLottoNumbers(): List<LottoNumber> {
        return (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)
            .shuffled()
            .take(Lotto.LOTTO_SIZE)
            .map { it.toLottoNumber() }
    }
}
