package lotto.domain

enum class MatchState(private val condition: Boolean) {
    MATCH(condition = true),
    NON_MATCH(condition = false),
    ;

    companion object {
        fun valueOf(condition: Boolean): MatchState = values().find { it.condition == condition } ?: NON_MATCH
    }
}
