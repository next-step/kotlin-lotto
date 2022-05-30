package racing.domain.gamerule

fun interface IssueStrategy {
    fun issue(): List<List<Int>>
}
