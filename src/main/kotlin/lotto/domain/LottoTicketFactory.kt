package lotto.domain

/**
 * 로또 번호를 자동으로 발급해주는 클래스
 * Created by Jaesungchi on 2022.05.24..
 */
object LottoTicketFactory {
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45
    val LOTTO_NUMBER_RANGE = MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER
    const val LOTTO_SIZE = 6

    fun getRandomLottoTicket(): LottoTicket {
        val numbers = LOTTO_NUMBER_RANGE
            .shuffled()
            .take(LOTTO_SIZE)
            .sorted()
        return LottoTicket.of(numbers)
    }
}
