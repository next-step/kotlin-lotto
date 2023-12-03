package camp.nextstep.edu.step.step2.domain.result

import camp.nextstep.edu.step.step2.dto.LottoResultDto

data class LottoResult(
    val lottoTotalPrice: Int,
    val lottoResults: List<LottoMatch>
) {

    init {
        require(lottoTotalPrice > 0) { "로또의 총 금액은 0보다 커야합니다." }
    }

    /**
     * @description : Lotto Match 결과를 토대로 OutputView에 전달할 LottoResultDto를 생성합니다.
     */
    fun calculateResultAndReturnDto(): LottoResultDto {
        LottoMatch.values().reversed().associateWith { lottoMatch ->
            getResultCount(lottoMatch)
        }.let { matchCount ->
            return LottoResultDto(
                matchResponse = matchCount.map { (lottoMatch, count) ->
                    LottoResultDto.MatchResponse(
                        lottoMatch.matchCount,
                        lottoMatch.prize,
                        count
                    )
                },
                lottoProfitRate = calculateProfitRate()
            )
        }
    }

    private fun calculateProfitRate(): Double {
        return lottoResults.sumOf { it.prize }.toDouble() / lottoTotalPrice
    }

    private fun getResultCount(lottoMatch: LottoMatch): Int {
        return lottoResults.count { it == lottoMatch }
    }

}
