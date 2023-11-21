package lotto.presentation.controller.dto

class EvaluateResponse private constructor(
    val rankResult: List<List<Int>>,
    val earningRate: Double,
) {
    companion object {
        fun from(lottoResultDto: LottoResultDto): EvaluateResponse {
            val rankResult = lottoResultDto.resultTable
            val earningRate = lottoResultDto.earingRate

            return EvaluateResponse(rankResult, earningRate)
        }
    }
}
