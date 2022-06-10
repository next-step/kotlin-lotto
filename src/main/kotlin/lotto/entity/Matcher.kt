package lotto.entity

interface Matcher {
    fun match(winningNumbers: List<Int>, tickets: List<LottoTicket>): List<Int>
}
