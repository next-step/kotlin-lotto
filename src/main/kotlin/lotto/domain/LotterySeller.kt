package lotto.domain

import lotto.dto.BuyLotteriesDTO
import lotto.dto.LotterySellDTO
import lotto.vo.Money

class LotterySeller(private val lotteryMachine: LotteryMachine) {

    fun sell(wallet: Wallet, lotterySellDTO: LotterySellDTO): BuyLotteriesDTO {
        wallet.withdraw(calculateLotteryAmount(lotterySellDTO.autoLotteryCount + lotterySellDTO.manualLotteryNumberSet.size))
        val autoLotteries = lotteryMachine.getLotteries(lotterySellDTO.autoLotteryCount)
        val manualLotteries = lotteryMachine.getManualLotteries(lotterySellDTO.manualLotteryNumberSet)
        return BuyLotteriesDTO(autoLotteries, manualLotteries)
    }

    private fun calculateLotteryAmount(count: Int) = Money(Lottery.PRICE * count)
}
