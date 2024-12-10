package lotto.controller

import lotto.domain.LottoTicket

class GeneratorRandomNumbers {
    companion object {
        fun generateLottoTicker(): LottoTicket {
            val numbers = mutableListOf<Int>()
            while (numbers.size < 6) {
                val number = (1..45).random()
                if (numbers.contains(number).not()) {
                    numbers.add(number)
                }
            }
            return LottoTicket(numbers.toList())
        }

        fun generateNumbers(count: Int): List<Int> {
            val numbers = mutableListOf<Int>()
            while (numbers.size < count) {
                val number = (1..45).random()
                if (numbers.contains(number).not()) {
                    numbers.add(number)
                }
            }
            return numbers.toList()
        }
    }
}
