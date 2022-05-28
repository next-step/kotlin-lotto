package lotto.domain

class Store(private val issuer: Issuable) {

    fun sell(request: PurchaseRequest): List<Lotto> {
        val lottoCount = request.money.amount / LOTTO_PRICE
        val manualCount = request.manualLottos.size

        require(lottoCount >= manualCount) { "금액이 부족합니다." }

        return request.manualLottos + List(lottoCount - manualCount) { issuer.issue() }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
