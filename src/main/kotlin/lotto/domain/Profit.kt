package lotto.domain

import lotto.dto.ResultDTO

object Profit {

    fun calculateLottoProfit(results: List<ResultDTO>):Int {
        return results.sumOf {
            it.matchNum * it.lottoEnum.price
        }
    }
}
