import model.Lotto
import model.LottoNumber

class LottoGame {
    fun buy(money: Int): List<Lotto> {
        val list = mutableListOf<Lotto>()

        repeat(money / LOTTO_PRICE) {
            val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
            val lotto = Lotto(lottoNumber)
            list.add(lotto)
        }

        return list.toList()
    }

    companion object {

        const val LOTTO_PRICE = 1_000
    }
}
