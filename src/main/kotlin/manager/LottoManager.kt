package manager

import model.DiceRandomMaker
import model.Lotto
import kotlin.properties.Delegates

class LottoManager {
    var lottoCount by Delegates.notNull<Int>()
        private set
    val lottoList: List<Lotto>
        get() = lottoListMutable.toList()

    private val lottoListMutable = mutableListOf<Lotto>()

    lateinit var prize: List<Int>

    val prizeList: List<Pair<Int, Int>>
        get() {
            val prizeMap = mutableMapOf<Int, Int>()
            for (lotto in lottoList) {
                val count = lotto.lottoNumber.count { prize.contains(it) }
                prizeMap[count] = (prizeMap[count] ?: 0) + 1
            }
            return prizeMap.toSortedMap().toList()
        }

    fun buy(value: Int) {
        lottoCount = value / LOTTO_PRICE
        if (lottoCount == 0) {
            throw IllegalArgumentException("please input minimum over $LOTTO_PRICE")
        }
        repeat(lottoCount) {
            val diceRandom = DiceRandomMaker()
            lottoListMutable.add(Lotto(diceRandom))
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
