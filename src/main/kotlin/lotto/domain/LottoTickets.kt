package lotto.domain

data class LottoTickets private constructor(val tickets: List<LottoTicket>) {

    fun matchWith(winningNumbers: WinningNumbers): Result {
        return Result(tickets.map { it.countWith(winningNumbers) })
    }

    companion object {
        fun make(totalCount: Int, manualLottoTickets: List<LottoTicket>): LottoTickets {
            val manualLottoCount = manualLottoTickets.count()
            validateLessThanLottoCount(manualLottoCount, totalCount)
            return LottoTickets(makeByAuto(totalCount - manualLottoCount) + manualLottoTickets)
        }

        private fun makeByAuto(totalCount: Int) = List(totalCount) { LottoTicket.generateByAuto() }

        private fun validateLessThanLottoCount(manualLottoCount: Int, totalLottoCount: Int) {
            require(manualLottoCount <= totalLottoCount) {
                "구입 금액보다 수동 갯수가 더 많습니다."
            }
        }
    }
}
