package lotto

class Matcher(val winNumbers: WinNumbers, private val policies: List<WinPolicy>) {

    fun makeResult(): List<MatchResult> {
        return policies.map {
            MatchResult(
                matchCount = 0,
                price = Money(0),
                winCount = 0
            )
        }
    }
}
