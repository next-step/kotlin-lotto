package lotto.domain

import lotto.util.LottoGenerator

object RandomLottoGenerator : LottoGenerator {
    private val lottoNumbers = (LottoNumber.LOTTO_MIN_NUMBER..LottoNumber.LOTTO_MAX_NUMBER).toList()

    override fun getLotto(): Lotto {
        return Lotto(lottoNumbers.shuffled().take(Lotto.LOTTO_NUMBER_SIZE).toSortedSet())
    }
}
