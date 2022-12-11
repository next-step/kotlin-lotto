package lotto.model

class LottoTicket {
    val lottoNumbers = makeNumbers()

    private fun makeNumbers(): List<Int> {
        return (LOTTO_WINNER_NUMBER_RANGE).toList().shuffled().take(6).sorted()
    }

    companion object {
        val LOTTO_WINNER_NUMBER_RANGE = 1..45
    }
}
