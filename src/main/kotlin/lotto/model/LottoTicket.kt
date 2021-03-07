package lotto.model

class LottoTicket {
    val numbers: List<Int> = autoCreate()

    private fun autoCreate() =
        List(NUMBERS_MAXIMUM) { i -> i + 1 }.shuffled().subList(0, NUMBERS_SIZE).sorted()

    companion object {
        const val NUMBERS_MAXIMUM = 45
        const val NUMBERS_SIZE = 6
    }
}
