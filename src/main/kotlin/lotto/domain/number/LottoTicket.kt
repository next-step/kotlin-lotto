package lotto.domain.number

class LottoTicket(val numbers: Set<LottoNumber>) {
    init {
        if (numbers.size != 6) throw IllegalArgumentException("로또는 한 장에 6개의 중복되지 않은 숫자로 이루어져 있습니다.")
    }

    companion object {
        fun from(numbers: Collection<Int>): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber.from(it) }.toSet())
        }
    }
}
