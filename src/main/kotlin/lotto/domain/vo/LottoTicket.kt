package lotto.domain.vo

import lotto.domain.Prize
import lotto.domain.enums.Rank
import lotto.dto.PurchaseAmountDto
import lotto.dto.RoiDto

@JvmInline
value class LottoTicket(private val lottoTicket: List<LottoNumber>) {
    init {
        require(lottoTicket.size == LottoTicketSize) { "로또 번호는 6개여야 합니다." }
        require(lottoTicket.distinct().size == 6) { "로또 번호는 중복될 수 없습니다." }
        require(lottoTicket == lottoTicket.sorted()) { "로또 번호는 오름차순으로 정렬되어야 합니다." }
    }

    fun evaluate(winningLottoTicket: LottoTicket): Prize {
        val prize = when (countSameNumber(winningLottoTicket)) {
            Rank.FIRST.matchNumber -> Rank.FIRST.prize
            Rank.SECOND.matchNumber -> Rank.SECOND.prize
            Rank.THIRD.matchNumber -> Rank.THIRD.prize
            Rank.FOURTH.matchNumber -> Rank.FOURTH.prize
            Rank.FIFTH.matchNumber -> Rank.FIFTH.prize
            Rank.SIXTH.matchNumber -> Rank.SIXTH.prize
            Rank.MISS.matchNumber -> Rank.MISS.prize
            else -> throw IllegalArgumentException("당첨 번호와 일치하는 로또 번호의 개수가 올바르지 않습니다.")
        }

        return prize
    }

    private fun countSameNumber(other: LottoTicket): Int {
        return this.lottoTicket.intersect(other.lottoTicket.toSet()).count()
    }

    companion object {
        const val LottoTicketSize = 6
    }
}
