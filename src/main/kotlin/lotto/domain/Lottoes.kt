package lotto.domain

class Lottoes(
    private val value: List<LottoTicket>
) {
    fun toList(): List<LottoTicket> {
        return value.toList()
    }
}
