package lotto.domain

class AutoStrategy : LottoStrategy {
    override fun generateLotto(quantity: Int): Lottoes {
        return Lottoes(
            (1..quantity).map {
                makeAutoLottoTicket()
            }
        )
    }

    private fun makeAutoLottoTicket(): LottoTicket {
        val numbers = (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER)
            .shuffled()
            .take(LottoTicket.LENGTH_OF_LOTTO)
            .sorted()

        return LottoTicket(
            numbers.map { number ->
                LottoNumber.from(number)
            }.toSet()
        )
    }
}
