package lotto.domain

class Numbers(val issueNumbers: List<Int> = Ticket.LOTTO_RANGE.shuffled().take(Ticket.LOTTO_COUNT).sorted()) {
    fun size() = this.issueNumbers.size

    fun duplicateSize() = this.issueNumbers.toSet().size

    fun getMatchingNumbers(numbers: Numbers) = this.issueNumbers.count { numbers.issueNumbers.contains(it) }
}
