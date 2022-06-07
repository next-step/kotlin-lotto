package lotto

import lotto.service.LottoService
import lotto.view.Input
import lotto.view.Output

fun main() {
    val money = Input.money()
    val randomNums = Input.getRandomLottoNumsPerMoney(money)
    val winNums = Input.winNums()

    val lottoService = LottoService()
    val lottoRanks = lottoService.getLottoRanks(randomNums, winNums)
    val revenueRate = lottoService.getRevenueRate(money.toDouble(), lottoRanks)

    Output.result(lottoRanks, revenueRate)
}
