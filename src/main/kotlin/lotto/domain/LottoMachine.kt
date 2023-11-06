package lotto.domain

class LottoMachine(val lottoPrice: Int) {
    fun purchase(price: Int): Lottos {
        val lottoList = mutableListOf<Lotto>()
        val numTickets = price / lottoPrice
        for (i in 1..numTickets) {
            lottoList.add(Lotto())
        }
        return Lottos(lottoList)
    }
}
