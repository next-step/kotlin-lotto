package domain

enum class Rank(val matchedCount: Int? = 0, val prize: Int = 0) {
    FAIL(null, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    fun isNotBoom(): Boolean = this != FAIL

    companion object {
        fun find(matchedCount: Int): Rank {
            return values().find { it.matchedCount == matchedCount } ?: FAIL
        }
    }
}
