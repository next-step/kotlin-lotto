package lotto

enum class Result(val condition: Int, val prizeIndex: Int = 0) {
    FOURTH(Result.FOURTH_CONDITION, 0),
    THIRD(Result.THIRD_CONDITION, 1),
    SECOND(Result.SECOND_CONDITION, 2),
    FIRST(Result.FIRST_CONDITION, 3),
    ELSE(Result.ELSE_CONDITION, 4);

    companion object {
        const val FOURTH_CONDITION = 3
        const val THIRD_CONDITION = 4
        const val SECOND_CONDITION = 5
        const val FIRST_CONDITION = 6
        const val ELSE_CONDITION = 0

        fun findResult(match: Int): Result {
            return values().firstOrNull { it.condition == match }
                ?: ELSE
        }
    }
}


