package lotto

import lotto.LottoNumber.Companion.LOTTO_NUMBER_RANGE
import lotto.LottoTicket.Companion.LOTTO_NUMBER_COUNT
import kotlin.random.Random

class LottoTicketFactory {

    fun createLottoTicket(): LottoTicket {
        return createDirectLottoTicket(
            generateSequence { Random(Random.nextInt()).nextInt(LOTTO_NUMBER_RANGE.first, LOTTO_NUMBER_RANGE.last) }
                .distinct()
                .take(LOTTO_NUMBER_COUNT)
                .sorted()
                .toList()
                .map(::LottoNumber)
        )
    }

    fun createDirectLottoTicket(formattedNumbers: List<LottoNumber>): LottoTicket {
        return LottoTicket(formattedNumbers)
    }
}
