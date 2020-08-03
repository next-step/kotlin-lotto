package manager

import model.DiceRandomMaker
import model.Lotto
import model.LottoPrize
import kotlin.properties.Delegates

class LottoManager {
    var lottoCount by Delegates.notNull<Int>()
        private set
    val lottoList: List<Lotto>
        get() = lottoListMutable.toList()

    val prizeStatList: List<Pair<LottoPrize, Int>>
        get() {
            val list = mutableListOf<Pair<LottoPrize, Int>>()
            for (lottoPrize in LottoPrize.values()) {
                prizeList.firstOrNull() { it.first == lottoPrize.grade }?.let { pair ->
                    list.add(Pair(lottoPrize, pair.second))
                }
            }
            return list.toList()
        }
    var purchaseAmount by Delegates.notNull<Int>()

    val earningRate: Double
        get() {
            val earningRate = (prizeStatList.sumBy { it.first.prizeMoney * it.second }.toDouble() / purchaseAmount)
            return String.format("%.2f", earningRate).toDouble()
        }

    private val lottoListMutable = mutableListOf<Lotto>()

    lateinit var prize: List<Int>

    private val prizeList: List<Pair<Int, Int>>
        get() {
            val prizeMap = mutableMapOf<Int, Int>()
            for (lotto in lottoList) {
                val count = lotto.lottoNumber.count { prize.contains(it) }
                prizeMap[count] = (prizeMap[count] ?: 0) + 1
            }
            return prizeMap.toSortedMap().toList()
        }

    fun buy(purchaseAmount: Int) {
        this.purchaseAmount = purchaseAmount
        lottoCount = purchaseAmount / LOTTO_PRICE
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
