package lotto.domain

class Numbers(
    val winNumbers: List<Int> = Ticket.LOTTO_RANGE.shuffled().take(Ticket.LOTTO_COUNT).sorted(),
    val bonusNumber: Int = 0
) {

    fun size() = this.winNumbers.size

    fun duplicateSize() = this.winNumbers.toSet().size
}
