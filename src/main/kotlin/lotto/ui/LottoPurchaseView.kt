package lotto.ui

object LottoPurchaseView {

    fun inputPriceForPurchase(): Long {
        println("구입금액을 입력해 주세요.")
        val inputPrice = readLine()!!.toLong()
        require(inputPrice >= 1_000) { "최소 1,000원 이상 입력해주세요." }
        require(inputPrice % 1_000 == 0L) { "1,000원 단위로 입력해주세요." }
        return inputPrice
    }

    fun printPurchaseResult(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }
}
