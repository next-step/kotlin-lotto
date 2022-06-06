package lotto.domain

object LottoTicketMachine {
    fun issue(nums: List<Int>): LottoTicket {
        val lottoBox = LottoBox()

        val lottoNums = nums.map {
            lottoBox.getLottoNum(it)
        }.toList()

        return LottoTicket(lottoNums)
    }
}
