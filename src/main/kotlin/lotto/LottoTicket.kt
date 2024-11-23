package lotto

class LottoTicket(numbers: Set<Int>) {

    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다." }
    }

    val numbers = numbers.sorted().map { LottoNumber.of(it) }

    companion object {
        fun autoGenerate(): LottoTicket {
            return (1..45).shuffled()
                .take(6)
                .toSet()
                .let { LottoTicket(it) }
        }
    }
}
