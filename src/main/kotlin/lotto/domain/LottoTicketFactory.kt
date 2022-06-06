package lotto.domain

/**
 * 로또 번호를 자동으로 발급해주는 클래스
 * Created by Jaesungchi on 2022.05.24..
 */
object LottoTicketFactory {
    const val LOTTO_SIZE = 6

    fun getRandomLottoTicket(): LottoTicket {
        val numbers = LottoNumber.LOTTO_NUMBER_RANGE
            .shuffled()
            .take(LOTTO_SIZE)
            .sorted()
        return LottoTicket.of(numbers)
    }
}
