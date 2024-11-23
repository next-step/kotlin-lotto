package lotto.domain

class LottoTicket private constructor(numbers: Set<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다. 입력된 숫자 = $numbers" }
    }

    val numbers = numbers.sorted().map { LottoNumber.of(it) }

    companion object {
        fun autoGenerate(): LottoTicket {
            return (1..45).shuffled()
                .take(6)
                .toSet()
                .let { LottoTicket(it) }
        }

        fun of(numbers: Set<Int>): LottoTicket {
            return LottoTicket(numbers)
        }
    }
}
