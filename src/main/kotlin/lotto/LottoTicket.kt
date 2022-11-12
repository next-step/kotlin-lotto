package lotto

class LottoTicket(
    val lottoNumbers: Set<LottoNumber>
) {
    init {
        require(lottoNumbers.size == 6)
    }
}