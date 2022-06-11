package lotto.view

import lotto.domain.Lottery
import lotto.dto.BuyLotteriesDTO
import lotto.infra.port.OutputSystem

class BuyResultView(private val outputSystem: OutputSystem) {

    fun printLotteries(buyLotteriesDTO: BuyLotteriesDTO) {
        printLottoCount(buyLotteriesDTO)
        printAllLotto(buyLotteriesDTO)
    }

    private fun printLottoCount(buyLotteriesDTO: BuyLotteriesDTO) {
        outputSystem.write("수동 ${buyLotteriesDTO.manualLotteries}.size}개, 자동 ${buyLotteriesDTO.autoLotteries.size}를 구매했습니다.\n")
    }

    private fun printAllLotto(buyLotteriesDTO: BuyLotteriesDTO) {
        buyLotteriesDTO.manualLotteries.forEach(::printLotto)
        buyLotteriesDTO.autoLotteries.forEach(::printLotto)
    }

    private fun printLotto(normalLottery: Lottery) = outputSystem.write("${normalLottery}\n")
}
