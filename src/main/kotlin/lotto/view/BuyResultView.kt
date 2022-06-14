package lotto.view

import lotto.dto.BuyLotteriesDTO
import lotto.infra.port.OutputSystem

class BuyResultView(private val outputSystem: OutputSystem) {

    fun printLotteries(buyLotteriesDTO: BuyLotteriesDTO) {
        printLottoCount(buyLotteriesDTO)
        printAllLotto(buyLotteriesDTO)
    }

    private fun printLottoCount(buyLotteriesDTO: BuyLotteriesDTO) {
        outputSystem.write(buyLotteriesDTO.printStatistics())
    }

    private fun printAllLotto(buyLotteriesDTO: BuyLotteriesDTO) {
        outputSystem.write(buyLotteriesDTO.printLotteries())
    }
}
