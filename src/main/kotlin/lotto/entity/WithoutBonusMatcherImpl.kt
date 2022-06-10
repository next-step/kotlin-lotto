package lotto.entity

class WithoutBonusMatcherImpl : Matcher {
    override fun match(winningNumbers: List<Int>, tickets: List<LottoTicket>): List<Int> {
        return listOf()
    }
}
