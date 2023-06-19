package lotto.domain

object LottoShop {

    fun getLottos(money: Int): Lottos {
        val tickets = getTicketCount(money)

        return Lottos.getLottos(tickets)
    }

    fun getTicketCount(money: Int): Int {
        require(money % 1000 == 0) { "1000원 단위로 입력해주세요." }

        return money / 1000
    }
}
