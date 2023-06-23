package lotto.domain

private const val BONUS_EXCEPTION = "보너스 볼은 로또번호와 달라야 합니다"

data class WinningTicket(val winningLotto: Lotto, val bonus: Int) {

    init {
        require(!winningLotto.contains(bonus)) { BONUS_EXCEPTION }
    }

    fun score(tickets: Tickets): List<Rank> {
        return tickets.tickets.map { Rank.getValue(this.winningLotto.getSameCount(it), it.contains(this.bonus)) }
    }

    fun calculateRateOfReturn(money: Int, score: List<Rank>): Float {
        val revenue = score.sumOf { it.reward }
        return revenue.toFloat() / money
    }
}
