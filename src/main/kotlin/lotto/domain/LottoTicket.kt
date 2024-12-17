package lotto.domain

class LottoTicket(numbers: List<LottoNumber>) {
    val lottoNumbers: List<LottoNumber>
        get() = field.toList()

    init {
        require(numbers.size == COUNT_OF_NUMBERS) { "로또 티켓은 ${COUNT_OF_NUMBERS}개의 번호가 필요해요." }
        lottoNumbers = numbers.toList()
    }

    fun correctNumberCount(ticket: LottoTicket): Int {
        return lottoNumbers.filter {
            ticket.lottoNumbers.contains(it)
        }.size
    }

    override fun toString(): String {
        return lottoNumbers.joinToString(
            separator = ", ",
            prefix = "[",
            postfix = "]",
        )
    }

    companion object {
        const val COUNT_OF_NUMBERS = 6
    }
}
