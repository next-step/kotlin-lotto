package lotto.model

data class LottoTicket(val numbers: List<Int> = autoCreate()) {
    companion object {
        private const val NUMBERS_MAXIMUM = 45
        private const val NUMBERS_SIZE = 6

        private fun autoCreate() =
            List(NUMBERS_MAXIMUM) { i -> i + 1 }.shuffled().subList(0, NUMBERS_SIZE).sorted()
    }
}
