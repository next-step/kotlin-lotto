package lotto.ui

import lotto.LottoSeller
import lotto.domain.Lotto

object LottoPurchaseView {
    fun inputPriceForPurchase(): Long {
        println("구입금액을 입력해 주세요.")
        val money = readLine()!!.toLong()
        require(money >= 1_000) { "최소 1,000원 이상 입력해주세요." }
        require(money % 1_000 == 0L) { "1,000원 단위로 입력해주세요." }
        return money
    }

    fun purchase(money: Long): List<Lotto> {
        val lottoList = LottoSeller.purchaseAuto(money)
        println("${lottoList.size}개를 구매했습니다.")
        return lottoList
    }
}
