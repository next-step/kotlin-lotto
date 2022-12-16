package lotto

enum class LottoStatus {
    WIN,
    NOT_WIN,
    WAITING,
    ;

    fun isWinStatus(): Boolean {
        return this == WIN
    }

    companion object {
        private const val MATCH_COUNT_FOR_WIN = 3

        fun from(matchCount: Int): LottoStatus {
            if (matchCount >= MATCH_COUNT_FOR_WIN) {
                return WIN
            }
            return NOT_WIN
        }
    }
}
