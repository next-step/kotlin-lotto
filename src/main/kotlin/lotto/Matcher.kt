package lotto

class Matcher(val winNumbers: WinNumbers, val policies: List<WinPolicy>) {

    fun makeResult(): List<MatchResult> {
        return listOf(
            MatchResult(matchCount = 0, price = Money(0), winCount = 0),
            MatchResult(matchCount = 0, price = Money(0), winCount = 0),
        )
    }
}
