package lotto.business

class LottoTicket(lottoNumber: List<LottoNumber>) {
    init {
        require(lottoNumber.distinct().size == 6) { "서로 다른 6개 로또 번호 이여야 합니다." }
    }
}
