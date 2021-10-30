package domain.lotto.strategy

import domain.lotto.domain.LottoNumber

object LottoRandomShuffleStrategy : LottoShuffleStrategy {
    override fun shuffle(lottoNumbers: List<LottoNumber>): List<LottoNumber> = lottoNumbers.shuffled()
}