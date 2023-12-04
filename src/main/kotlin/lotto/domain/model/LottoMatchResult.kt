package lotto.domain.model

/**
 * 로또 결과
 * */
data class LottoMatchResult(val matchCount: MatchCount, val prize: Prize, val winningTicketCount: WinningTicketCount, val bonusMatch: BonusMatch)
