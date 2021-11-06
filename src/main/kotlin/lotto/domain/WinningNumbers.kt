package lotto.domain

class WinningNumbers(private val winning: LottoNumbers, private val bonus: LottoNumber) {

    init {
        require(!winning.contains(bonus)) { "당첨 번호와 보너스 번호는 중복될 수 없습니다." }
    }

    fun countSameNumber(ticket: LottoNumbers): Int {
        return winning.countSameNumber(ticket)
    }

    fun containsBonus(ticket: LottoNumbers): Boolean {
        return ticket.contains(bonus)
    }
}
