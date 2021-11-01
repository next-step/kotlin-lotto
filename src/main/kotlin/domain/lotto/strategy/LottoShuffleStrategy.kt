package domain.lotto.strategy

import domain.lotto.domain.LottoNumber

fun interface LottoShuffleStrategy {
    fun shuffle(lottoNumbers: List<LottoNumber>): List<LottoNumber>
}
