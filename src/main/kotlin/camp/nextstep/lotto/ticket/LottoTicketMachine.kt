package camp.nextstep.lotto.ticket

import kotlin.random.Random

class LottoTicketMachine(private val numbersGenerator: NumbersGenerator = RandomNumbersGenerator(LottoTicket.LOTTO_NUMBER_RANGE, LottoTicket.LOTTO_NUMBERS)) {

    fun issueTicket(): LottoTicket {
        val numbers = numbersGenerator.numbers()

        return LottoTicket(numbers)
    }

    interface NumbersGenerator {
        fun numbers(): List<Int>
    }

    private class RandomNumbersGenerator(private val range: IntRange, private val n: Int) : NumbersGenerator {

        override fun numbers() =
            generateSequence { Random(Random.Default.nextInt()).nextInt(range.first, range.last) }
                .distinct()
                .take(n)
                .sorted()
                .toList()
    }
}
