package lotto.model

class RandomLottoTicketGenerator : LottoTicketGenerator {
    val lottoNumbers: List<Int> = generate()

    override fun generate(): List<Int> {
        return (LOTTO_WINNER_NUMBER_RANGE).shuffled().take(6).sorted()
    }

    companion object {
        val LOTTO_WINNER_NUMBER_RANGE = 1..45
    }
}
