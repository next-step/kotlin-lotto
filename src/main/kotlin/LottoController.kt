import domain.LottoInput
import domain.WinningLotto
import service.AutoNumberGenerator
import service.CalculateWinningStatistic
import service.RandomNumberGenerator
import service.WinningNumberRegister

class LottoController {
    fun start(){
        val amount = 14000
        val lottoInput = LottoInput(totalPrice = amount)
        val randomNumberGenerator = RandomNumberGenerator(1,45)
        val autoNumberGenerator = AutoNumberGenerator(randomNumberGenerator)
        val generatedLottos = autoNumberGenerator.saveAfterGenerate(amount/1000)
        val winning = listOf<Int>(1,6,7,8,9,10)
        lottoInput.of(LottoInput(winningLotto = winning))
        val winningNumberRegister = WinningNumberRegister(randomNumberGenerator)
        val winningLotto = winningNumberRegister.register(lottoInput)
        val calculateWinningStatistic = CalculateWinningStatistic()
        val ranks = calculateWinningStatistic.calculateRank(generatedLottos, winningLotto)
        val prize = calculateWinningStatistic.calculatePrize(ranks)
        val rate = calculateWinningStatistic.calculateRate(prize, lottoInput.totalPrice!!)

    }
}

fun main() {
    LottoController().start()
}