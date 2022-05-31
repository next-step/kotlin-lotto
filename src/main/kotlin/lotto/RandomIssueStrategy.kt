import kotlin.random.Random

class RandomIssueStrategy(val count: Int) : IssueStrategy {
    private val ISSUE_RANGE = 1..(count)

    override fun issue(): List<List<Int>> {
        return ISSUE_RANGE.map {
            generateSequence { Random(Random.nextInt()).nextInt(LOTTO_NUMBER_RANGE.first, LOTTO_NUMBER_RANGE.last) }
                .distinct()
                .take(LOTTO_NUMBER_COUNT)
                .sorted()
                .toList()
        }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
    }
}
