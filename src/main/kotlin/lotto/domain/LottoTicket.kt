package lotto.domain

data class LottoTicket(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(lottoNumbers.size == COUNT_OF_NUMBERS) { "로또 티켓은 ${COUNT_OF_NUMBERS}개의 번호가 필요해요." }
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
