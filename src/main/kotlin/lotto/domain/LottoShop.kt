package lotto.domain

object LottoShop {

    private const val LOTTO_PRICE = 1000

    fun getLottos(money: Int, manualLottos: List<List<Int>>): Lottos {
        val autoLottoTicketMoney = money - (manualLottos.size * LOTTO_PRICE)
        return Lottos.getCombinedLottos(getManualLottos(manualLottos), getAutoLottos(autoLottoTicketMoney))
    }

    fun getAutoLottos(money: Int): Lottos {
        val tickets = getTicketCount(money)

        return Lottos.getAutoLottos(tickets)
    }

    fun getManualLottos(list: List<List<Int>>): Lottos {
        return Lottos.getManualLottos(list)
    }

    fun getTicketCount(money: Int): Int {
        require(money % 1000 == 0) { "1000원 단위로 입력해주세요." }

        return money / 1000
    }
}
