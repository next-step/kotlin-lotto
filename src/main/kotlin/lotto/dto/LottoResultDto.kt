package lotto.dto

import lotto.domain.LottoResult

@JvmInline
value class LottoResultDto(private val lottoResult: LottoResult) {
    fun getResult(): Map<LottoRankDto, Int> {
        return lottoResult.value.mapKeys { LottoRankDto(it.key.countOfMatch, it.key.winningMoney) }
    }
}
