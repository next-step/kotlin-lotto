package lotto

class LottoTicket(
    val lottoNumbers: List<LottoNumber>
) {
    init {
        require(lottoNumbers.size == 6)
    }
}