package lotto.domain

class Numbers(val values: List<Int> = Ticket.LOTTO_RANGE.shuffled().take(Ticket.LOTTO_COUNT).sorted()) {

    fun size() = this.values.size

    fun duplicateSize() = this.values.toSet().size
}
