package lotto.domain

object LottoShop {

    fun getLottos(money: Int, list: List<List<Int>>): Lottos {
        return (getManualLottos(list).list + getAutoLottos(money - list.size * 1000).list).toLottos()
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
