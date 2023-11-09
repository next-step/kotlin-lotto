package lotto.model

class LottoTicket(val lottoNumbers: LottoNumbers) {
    override fun toString(): String {
        return lottoNumbers.toString()
    }
}
