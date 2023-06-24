package lotto.domain

private const val BONUS_EXCEPTION = "보너스 볼은 로또번호와 달라야 합니다"

data class WinningTicket(val winningLotto: Lotto, val bonus: Int) {

    init {
        require(!winningLotto.contains(bonus)) { BONUS_EXCEPTION }
    }

    fun score(tickets: Tickets): Score {
        return Score(tickets.tickets.map { Rank.getValue(this.winningLotto.getSameCount(it), it.contains(this.bonus)) })
    }
}
