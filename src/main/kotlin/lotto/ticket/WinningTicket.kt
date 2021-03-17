package lotto.ticket

class WinningTicket(
    policy: LottoDrawPolicy
) {
    private val lottoNumbers: Set<LottoNumber> = policy.draw()

    fun matchNumber(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        fun ofTxNumbers(txNumbers: String): WinningTicket {
            return WinningTicket(ManualDrawPolicy(txNumbers))
        }
    }
}
