package lotto

enum class LottoTicketStatus {
    WIN, NOT_WIN, WAITING;

    fun isWinStatus(): Boolean {
        return this == WIN
    }

    companion object {
        private const val MATCH_COUNT_FOR_WIN = 3

        fun from(matchCount: Int): LottoTicketStatus {
            if (matchCount >= MATCH_COUNT_FOR_WIN) {
                return WIN
            }
            return NOT_WIN
        }
    }
}
