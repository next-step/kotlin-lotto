import lotto.domain.LotteryMachine
import lotto.domain.LotterySeller
import lotto.domain.Wallet
import lotto.dto.LotteryResultDTO
import lotto.dto.LotterySellDTO
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
    val orderLotteryRequestDTO = inputMoneyView.orderLottery()

    val lotterySeller = LotterySeller(LotteryMachine(lottoNumberGenerator))

    val wallet = Wallet(orderLotteryRequestDTO.money)
    val lotterySellDTO = LotterySellDTO(
        orderLotteryRequestDTO.manualLotteryNumbers,
        orderLotteryRequestDTO.autoLotteryCount,
    )
    val buyLotteriesDTO = lotterySeller.sell(wallet, lotterySellDTO)

    val buyResultView = BuyResultView(ioSystem)
    buyResultView.printLotteries(buyLotteriesDTO)

    val lastWeekLottoView = InputLastWeekLottoView(ioSystem)
    val winningLottery = lastWeekLottoView.getLastWeekLotto()
    val lottoResultView = LottoResultView(ioSystem)
    val lotteryResultDTO =
        LotteryResultDTO(buyLotteriesDTO.autoLotteries, buyLotteriesDTO.manualLotteries, winningLottery)
    lottoResultView.printResult(lotteryResultDTO)
}
