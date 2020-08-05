package manager

import model.DiceRandomMaker
import model.Lotto
import model.LottoPrize
import model.PrizeEarn
import kotlin.properties.Delegates

class LottoManager() {
    val lottoList: List<Lotto>
        get() = lottoListMutable.toList()

    val prizeStatList: List<PrizeEarn>
        get() {
            val list = mutableListOf<PrizeEarn>()
            for (lottoPrize in LottoPrize.values()) {
                prizeList.firstOrNull { it.first == lottoPrize.grade }?.let { pair ->
                    list.add(PrizeEarn(lottoPrize, pair.second))
                }
            }
            return list.toList()
        }

    val earningRate: Double
        get() {
            val earningRate = (prizeStatList.sumBy { it.totalPrizeMoney }.toDouble() / purchaseAmount)
            return String.format("%.2f", earningRate).toDouble()
        }

    var lottoCount by Delegates.notNull<Int>()
        private set

    lateinit var prize: List<Int>

    private val lottoListMutable = mutableListOf<Lotto>()

    private val prizeList: List<Pair<Int, Int>>
        get() {
            return prizeMap().toSortedMap().toList()
        }

    private var purchaseAmount by Delegates.notNull<Int>()

    fun buy(purchaseAmount: Int) {
        this.purchaseAmount = purchaseAmount
        lottoCount = purchaseAmount / LOTTO_PRICE
        checkLottoPrice()
        repeat(lottoCount) {
            addLotto()
        }
    }

    private fun prizeMap(): MutableMap<Int, Int> {
        val prizeMap = mutableMapOf<Int, Int>()
        for (lotto in lottoList) {
            addMap(lotto, prizeMap)
        }
        return prizeMap
    }

    private fun addMap(lotto: Lotto, prizeMap: MutableMap<Int, Int>) {
        val count = lotto.lottoNumber.count { prize.contains(it) }
        prizeMap[count] = (prizeMap[count] ?: 0) + 1
    }

    private fun addLotto() {
        val diceRandom = DiceRandomMaker()
        lottoListMutable.add(Lotto(diceRandom))
    }

    private fun checkLottoPrice() {
        if (lottoCount == 0) {
            throw IllegalArgumentException("please input minimum over $LOTTO_PRICE")
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
