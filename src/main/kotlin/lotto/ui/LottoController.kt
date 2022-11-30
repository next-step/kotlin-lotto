package lotto.ui

import lotto.domain.*
import lotto.ui.view.InputView
import lotto.ui.view.ResultView

class LottoController {
   fun main(args: Array<String>) {
       val purchasePrice = chargePaymentAmount()
       val purchaseLotto = purchaseLotto(purchasePrice)
       val ticketingLottoList = ticketingLotto(purchaseLotto)

       val winningLottoNumbers = drawWinningLottoNumbers()
       validateWinningLottoNumbersCondition(winningLottoNumbers)
       val winningLotto = Lotto(winningLottoNumbers)

       val winningAmountList = calculateWinningAmount(ticketingLottoList, winningLotto)

       printLottoResult()
   }

   private fun chargePaymentAmount(): Int {
       return InputView.getPurchasePrice()
   }

   private fun purchaseLotto(purchasePrice: Int): Int {
       return LottoSaleMachine.purchase(purchasePrice)
   }

   private fun ticketingLotto(purchaseLotto: Int): List<Lotto> {
       return MutableList(purchaseLotto) {
           Lotto(LottoNumbersGenerator.generate())
       }
   }

   private fun drawWinningLottoNumbers(): List<Int> {
       return InputView.getWinningLotto()
   }

   private fun validateWinningLottoNumbersCondition(winningLottoNumbers: List<Int>): Boolean {
       if(!LottoNumbersValidator.validate(winningLottoNumbers)) throw IllegalArgumentException("유효하지 않은 로또 번호입니다.")

       return true
   }

   private fun calculateWinningAmount(ticketingLottoList: List<Lotto>, winningLotto: Lotto): Map<Int, Int> {
        var winningAmountList = mutableMapOf(
            LottoReward.MATCH_THREE.rewardPrice to 0,
            LottoReward.MATCH_FOUR.rewardPrice to 0,
            LottoReward.MATCH_FIVE.rewardPrice to 0,
            LottoReward.MATCH_SIX.rewardPrice to 0,
        )

       ticketingLottoList.forEach { ticketingLotto ->
           val matchCount = LottoNumbersMatcher.calculateMatchCount(ticketingLotto, winningLotto)

           var lottoReward = try {
               LottoReward.find(matchCount)
           } catch (e: RuntimeException) {
               null
           }

           var rewardPrice = lottoReward?.rewardPrice
           if (rewardPrice != null) {
               winningAmountList[rewardPrice] = (winningAmountList[rewardPrice] ?: 0) + 1
           }
       }

       return winningAmountList
   }

   private fun printLottoResult() {
       ResultView.printLottoResult()
   }
}