package camp.nextstep.lotto.ticket

import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumbers
import kotlin.random.Random

class LottoTicketMachine(private val numbersGenerator: NumbersGenerator = RandomNumbersGenerator(LottoNumber.LOTTO_NUMBER_RANGE, LottoNumbers.LOTTO_NUMBERS)) {

    fun issueTicket(numbers: LottoNumbers): LottoTicket {
        return LottoTicket.of(numbers)
    }

    fun issueTicket(): LottoTicket {
        val numbers = numbersGenerator.numbers()

        return LottoTicket.of(numbers)
    }

    interface NumbersGenerator {
        fun numbers(): LottoNumbers
    }

    private class RandomNumbersGenerator(private val range: IntRange, private val n: Int) : NumbersGenerator {

        override fun numbers() = LottoNumbers.of(
            generateSequence { Random(Random.Default.nextInt()).nextInt(range.first, range.last) }
                .distinct()
                .take(n)
                .sorted()
                .toList()
        )
    }
}
