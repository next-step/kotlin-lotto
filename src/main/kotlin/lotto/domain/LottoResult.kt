package lotto.domain

import lotto.dto.ResultDTO

object LottoResult {
    fun calculateResult(lottos: Lottos, lottoResult: WinningLotto): List<ResultDTO> {
        return lottos.map { lotto ->
            Pair(
                lotto.numbers.count { it in lottoResult.lotto.numbers },
                lotto.numbers.map { it.number }.contains(lottoResult.bonusNumber.number)
            )
        }.mapNotNull {
            LottoRank.of(it.first, it.second)
        }.groupBy {
            it
        }.map {
            ResultDTO(it.value.size, it.key)
        }
    }
}
