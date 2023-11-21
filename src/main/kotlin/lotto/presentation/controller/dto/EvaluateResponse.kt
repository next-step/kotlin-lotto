package lotto.presentation.controller.dto

import lotto.presentation.controller.LottoResult

class EvaluateResponse private constructor(
    val rankResult: List<List<Int>>,
    val earningRate: Double,
) {
    companion object {
        fun from(lottoResult: LottoResult): EvaluateResponse {
            val rankResult = lottoResult.getResultTable()
            val earningRate = lottoResult.getEarningRate()

            return EvaluateResponse(rankResult, earningRate)
        }
    }
}
