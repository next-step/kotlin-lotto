package lotto.domain

import lotto.dto.ResultDTO

object LottoResult {
    fun calculateResult(lottos: Lottos, lottoResult: Lotto): List<ResultDTO> {
        return lottos.list.map { lotto ->
            lotto.numbers.count { it in lottoResult.numbers }
        }.mapNotNull {
            LottoRank.of(it)
        }.groupBy {
            it
        }.map {
            ResultDTO(it.value.size, it.key)
        }
    }
}
