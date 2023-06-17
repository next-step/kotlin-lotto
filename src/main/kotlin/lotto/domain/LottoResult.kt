package lotto.domain

import lotto.dto.ResultDTO

object LottoResult {
    fun calculateResult(lottos: Lottos, lottoResult: Lotto): List<ResultDTO> {
        val sortedResult = lottoResult.numbers.sorted()

        return lottos.list.map { lotto ->
            lotto.numbers.count { it in sortedResult }
        }.mapNotNull {
            LottoRank.of(it)
        }.groupBy {
            it
        }.map {
            ResultDTO(it.value.size, it.key)
        }
    }
}
