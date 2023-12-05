package camp.nextstep.edu.step.step2.dto

data class LottoResultDto (
    val matchResponse: List<MatchResponse>,
    val lottoProfitRate: Double
    ) {

    data class MatchResponse(
        val matchCount: Int,
        val prize: Int,
        val userMatchCont: Int
    )
}
