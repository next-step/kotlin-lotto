package lotto.domain.model

import lotto.domain.model.vo.BonusMatch
import lotto.domain.model.vo.MatchCount
import lotto.domain.model.vo.Prize
import lotto.domain.model.vo.WinningTicketCount

/**
 * 로또 결과
 * */
data class LottoMatchResult(val matchCount: MatchCount, val prize: Prize, val winningTicketCount: WinningTicketCount, val bonusMatch: BonusMatch)
