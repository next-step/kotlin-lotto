package lotto.domain

class LottoTicketMachine(private val lottoBox: LottoBox) {

    fun issue(nums: List<Int>): LottoTicket {

        val lottoNums = nums.map {
            lottoBox.getLottoNum(it)
        }.toList()

        return LottoTicket(lottoNums)
    }
}
