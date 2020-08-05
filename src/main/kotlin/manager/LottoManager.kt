package manager

import model.DiceRandomMaker
import model.Lotto
import model.LottoPrize
import model.PrizeEarn
import service.LottoService
import service.MatchService
import kotlin.properties.Delegates

class LottoManager() {
    private val lottoService = LottoService()
    private lateinit var matchService: MatchService

    val lottoList: List<Lotto>
        get() = lottoService.lottoList.toList()

    val lottoCount: Int
        get() = lottoList.size

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

    private val prizeList: List<Pair<Int, Int>>
        get() = matchService.prizeList

    private var purchaseAmount by Delegates.notNull<Int>()

    fun buy(purchaseAmount: Int) {
        this.purchaseAmount = purchaseAmount
        val lottoCount = purchaseAmount / LOTTO_PRICE
        checkLottoPrice(lottoCount)
        repeat(lottoCount) {
            lottoService.create(DiceRandomMaker())
        }
    }

    fun setPrize(prize: List<Int>) {
        matchService = MatchService(prize, lottoList)
    }

    private fun checkLottoPrice(lottoCount: Int) {
        if (lottoCount == 0) {
            throw IllegalArgumentException("please input minimum over $LOTTO_PRICE")
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
