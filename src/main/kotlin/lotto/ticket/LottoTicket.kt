package lotto.ticket

class LottoTicket(
    policy: LottoDrawPolicy
) {
    val lottoNumbers: Set<LottoNumber> = policy.draw()

    fun hasWinningNumber(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        private val AUTO_DRAW_POLICY: LottoDrawPolicy = AutoDrawPolicy()

        fun ofAuto(): LottoTicket {
            return LottoTicket(AUTO_DRAW_POLICY)
        }
    }
}
