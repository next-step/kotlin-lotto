package specific.lotto.domain

enum class Rank(val prize: Long) {
    FIRST(2000000000L),
    SECOND(1500000L),
    THIRD(50000L),
    FOURTH(5000L),
    NO_WIN(0L);

    companion object {
        fun decideRank(ticket: Ticket, winningSet: WinningSet): Rank {
            return when(ticket.countSameNumber(winningSet)) {
                6 -> FIRST
                5 -> SECOND
                4 -> THIRD
                3 -> FOURTH
                else -> NO_WIN
            }
        }
    }
}
