package lotto.domain.result

import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_COUNT

class MatchInfo private constructor(private val info: Pair<Int, Boolean>) {
    val matchCount: Int
        get() = info.first
    val hasBonus: Boolean
        get() = info.second

    init {
        require(info.first <= LOTTO_NUMBER_COUNT) { "매치 수는 로또 숫자의 수 보다 클 수 없습니다." }
    }

    companion object {
        fun of(matchCount: Int, hasBonus: Boolean): MatchInfo {
            return MatchInfo(Pair(matchCount, hasBonus))
        }
    }
}
