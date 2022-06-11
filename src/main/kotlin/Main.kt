import lotto.domain.LotterySeller
import lotto.domain.LotteryStore
import lotto.domain.Wallet
import lotto.dto.BuyLotteriesDTO
import lotto.dto.LotteryResultDTO
import lotto.infra.DefaultIOSystem
import lotto.infra.LottoNumberGenerator
import lotto.view.BuyResultView
import lotto.view.InputLastWeekLottoView
import lotto.view.InputMoneyView
import lotto.view.LottoResultView

fun main() {
    val ioSystem = DefaultIOSystem()
    val lottoNumberGenerator = LottoNumberGenerator()

    val inputMoneyView = InputMoneyView(ioSystem)
    val orderLotteryRequestDTO = inputMoneyView.getMoney()

    val lotterySeller = LotterySeller(LotteryStore(lottoNumberGenerator))

    val wallet = Wallet(orderLotteryRequestDTO.money)
    val autoLotteries = lotterySeller.sell(wallet, 3)
    val manualLotteries = lotterySeller.sellManually(wallet, orderLotteryRequestDTO.manualLotteryNumbers)
    val buyLotteriesDTO = BuyLotteriesDTO(autoLotteries, manualLotteries)

    val buyResultView = BuyResultView(ioSystem)
    buyResultView.printLotteries(buyLotteriesDTO)

    val lastWeekLottoView = InputLastWeekLottoView(ioSystem)
    val winningLottery = lastWeekLottoView.getLastWeekLotto()
    val lottoResultView = LottoResultView(ioSystem)
    val lotteryResultDTO = LotteryResultDTO(buyLotteriesDTO.autoLotteries, buyLotteriesDTO.manualLotteries, winningLottery)
    lottoResultView.printResult(lotteryResultDTO)
}
