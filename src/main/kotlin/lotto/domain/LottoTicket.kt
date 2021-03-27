package lotto.domain

class LottoTicket(
    manualLottos: List<Lotto>,
    automaticLottos: List<Lotto>,
    val price: LottoPrice
) {
    val lottos: List<Lotto> = manualLottos + automaticLottos
    val automaticCount: Int = automaticLottos.size
    val manualCount: Int = manualLottos.size

    init {
        require(price.isExceedPriceByCount(lottos.size)) {
            "로또 구매수는 구입금액을 초과할 수 없습니다."
        }
    }
}
