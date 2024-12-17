package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_RANGE
import lotto.domain.LottoTicket.Companion.COUNT_OF_NUMBERS

class GeneratorLottoNumbers(private val range: IntRange = LOTTO_NUMBER_RANGE) {
    init {
        require(range.first >= LOTTO_NUMBER_RANGE.first) { "로또 번호는 ${LOTTO_NUMBER_RANGE.first} 이상이어야 해요" }
        require(range.last <= LOTTO_NUMBER_RANGE.last) { "로또 번호는 ${LOTTO_NUMBER_RANGE.last} 이하이어야 해요" }
        require(range.last - range.first + 1 >= COUNT_OF_NUMBERS) { "${COUNT_OF_NUMBERS}개 이상의 숫자가 필요해요" }
    }

    private fun getLottoNumbers(): List<LottoNumber> {
        val shuffledNumbers = range.shuffled()
        return shuffledNumbers.take(COUNT_OF_NUMBERS).map {
            LottoNumber(it)
        }.toList()
    }

    fun generateRandomLottoTickets(count: Int): List<LottoTicket> {
        return buildList {
            for (index in 1..count)
                add(LottoTicket(getLottoNumbers()))
        }
    }
}
