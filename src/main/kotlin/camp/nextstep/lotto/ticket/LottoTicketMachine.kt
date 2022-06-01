package camp.nextstep.lotto.ticket

import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumbers
import kotlin.random.Random

class LottoTicketMachine(private val numbersGenerator: NumbersGenerator = RandomNumbersGenerator(LottoNumbers.LOTTO_NUMBER_RANGE, LottoNumbers.LOTTO_NUMBERS)) {

    fun issueTicket(numbers: List<LottoNumber>): LottoTicket {
        return LottoTicket(numbers)
    }

    fun issueTicket(): LottoTicket {
        val numbers = numbersGenerator.numbers()

        return LottoTicket(numbers)
    }

    interface NumbersGenerator {
        fun numbers(): List<LottoNumber>
    }

    private class RandomNumbersGenerator(private val range: IntRange, private val n: Int) : NumbersGenerator {

        override fun numbers() =
            generateSequence { Random(Random.Default.nextInt()).nextInt(range.first, range.last) }
                .distinct()
                .take(n)
                .sorted()
                .map { LottoNumber.of(it) }
                .toList()
    }
}
