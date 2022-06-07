package lotto.domain

object LottoTicketMachine {
    fun issue(nums: List<Int>): LottoTicket {
        require(nums.size == 6) {
            "로또 개수를 잘못 입력했습니다"
        }

        val lottoBox = LottoBox()

        val lottoNums = nums.map {
            lottoBox.getLottoNum(it)
        }.toList()

        return LottoTicket(lottoNums)
    }
}
