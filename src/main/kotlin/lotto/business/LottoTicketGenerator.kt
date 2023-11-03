package lotto.business

class LottoTicketGenerator(private val randomLottoPicker: RandomLottoPicker = RandomLottoPicker()) {
    fun generate(): LottoTicket {
        val lottoNumbers = randomLottoPicker.pick()
        return LottoTicket(lottoNumbers)
    }

    fun generate(quantity: Int): List<LottoTicket> {
        return (1..quantity).map { generate() }
    }
}
