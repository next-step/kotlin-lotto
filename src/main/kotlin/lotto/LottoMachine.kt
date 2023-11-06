package lotto

class LottoMachine(val lottoPrice: Int) {
    fun purchase(price: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        val numTickets = price / lottoPrice
        for (i in 1..numTickets) {
            lottoList.add(Lotto())
        }
        return lottoList
    }
}
