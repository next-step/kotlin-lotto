package manager

import model.DiceRandomMaker
import model.Lotto
import model.PrizeEarn
import service.CalculateService
import service.LottoService
import service.MatchService
import kotlin.properties.Delegates

class LottoManager() {
    private val lottoService = LottoService()
    private lateinit var matchService: MatchService
    private lateinit var calculateService: CalculateService

    val lottoList: List<Lotto>
        get() = lottoService.lottoList

    val lottoCount: Int
        get() = lottoList.size

    val prizeStatList: List<PrizeEarn>
        get() = calculateService.prizeStatList

    val earningRate: Double
        get() = String.format("%.2f", calculateService.getEarningRate(purchaseAmount)).toDouble()

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
        calculateService = CalculateService(matchService.prizeList)
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
