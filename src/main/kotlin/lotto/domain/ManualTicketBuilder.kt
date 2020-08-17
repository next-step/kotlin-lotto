package lotto.domain

class ManualTicketBuilder {
    companion object {
        fun sellTickets(inputStrings: List<String>): List<Ticket> {
            return inputStrings.map {
                create(it)
            }
        }

        private fun create(it: String) = Ticket(toIntSet(it))

        private fun toIntSet(it: String) = it.split(",").map { it.trim().toInt() }.toSet()
    }
}
