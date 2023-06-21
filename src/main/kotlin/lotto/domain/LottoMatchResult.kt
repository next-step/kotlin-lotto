package lotto.domain

/**
 * ### 로또와 당첨 번호를 비교한 결과를 표현하는 클래스 입니다.
 *
 * 비교 결과를 토대로 로또의 등수를 알 수 있습니다.
 */
data class LottoMatchResult(
    val matchCount: Int,
    val bonusMatched: Boolean = false,
) {
    val rank = LottoRank.valueOf(matchCount, bonusMatched)
}
