package lotto.model

enum class Prize(
    val matched: Int, val prize: Int
) {
    First(6, 2000000000),
    Second(5, 1500000),
    Third(5, 50000),
    Fourth(4, 5000),
    MISS(0, 0);

    companion object {
        fun getKeyWithMatched(matched: Int): Prize = when(matched){
            First.matched -> First
            Second.matched -> Second
            Third.matched -> Third
            Fourth.matched -> Fourth
            else -> MISS
        }
    }
}
