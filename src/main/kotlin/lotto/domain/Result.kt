package lotto.domain

enum class Result(val matchCondition: Int, val winningResultsIndex: Int = 0) {
    FOURTH(3, 0),
    THIRD(4, 1),
    SECOND(5, 2),
    FIRST(6, 3),
    ELSE(0, 4);

    companion object {
        fun getResult(matchSuccess: Int): Result {
            return values().firstOrNull { it.matchCondition == matchSuccess }
                ?: ELSE
        }
    }
}
