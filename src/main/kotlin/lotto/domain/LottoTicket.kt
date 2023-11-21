package lotto.domain

class LottoTicket private constructor(val numbers: List<Int>) {
    infix fun countSameNumberWith(other: LottoTicket): Int {
        return numbers.count { other.numbers.contains(it) }
    }

    infix fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        fun of(numbers: List<Int>): LottoTicket {
            return LottoTicket(numbers)
        }
    }
}
