package lotto.dto

import lotto.domain.Match

data class ResultDto(val ratio: Double, val result: String) {
    companion object {
        fun of(ratio: Double, countedMatches: Map<Match, Int>): ResultDto {
            return ResultDto(ratio, serialize(countedMatches))
        }

        private fun serialize(countedMatches: Map<Match, Int>): String {
            val defaultCount = 0
            return serialize(
                Match.THREE,
                countedMatches.getOrDefault(Match.THREE, defaultCount)
            ) + serialize(
                Match.FOUR,
                countedMatches.getOrDefault(Match.FOUR, defaultCount)
            ) + serialize(
                Match.FIVE,
                countedMatches.getOrDefault(Match.FIVE, defaultCount)
            ) + serialize(
                Match.SIX,
                countedMatches.getOrDefault(Match.SIX, defaultCount)
            )
        }

        private fun serialize(match: Match, count: Int): String {
            return "${getPrefix(match)} (${match.prize}원) - ${count}개\n"
        }

        private fun getPrefix(match: Match): String {
            return when (match) {
                Match.THREE -> "3개 일치"
                Match.FOUR -> "4개 일치"
                Match.FIVE -> "5개 일치"
                Match.SIX -> "6개 일치"
                Match.NONE -> ""
            }
        }
    }
}
