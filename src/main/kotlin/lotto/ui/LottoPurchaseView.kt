package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import lotto.domain.LottoSeller

object LottoPurchaseView {
    fun inputPriceForPurchase(): Long {
        println("구입금액을 입력해 주세요.")
        val inputPrice = readln().toLongOrNull()
        requireNotNull(inputPrice) { "구매금액이 올바르게 입력되지 않았습니다." }
        require(inputPrice >= LottoSeller.LOTTO_PRICE) { "최소 1,000원 이상 입력해주세요." }
        require(inputPrice % LottoSeller.LOTTO_PRICE == 0L) { "1,000원 단위로 입력해주세요." }
        return inputPrice
            .also { println() }
    }

    fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val inputManualLottoCount = readln().toIntOrNull()
        requireNotNull(inputManualLottoCount) { "수동으로 구매할 로또 수가 올바르게 입력되지 않았습니다." }
        return inputManualLottoCount
            .also { println() }
    }

    fun inputManualLottoNumbers(manualLottoCount: Int): List<LottoNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(manualLottoCount) {
            readln().split(",")
                .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException() }
                .let { LottoNumbers.from(it) }
        }.also { println() }
    }

    fun printPurchaseResult(lottoList: List<Lotto>) {
        val (manualLottoCount, autoLottoCount) = lottoList.groupingBy { it.isAutoPick }
            .eachCount()
            .values
            .toTypedArray()
        println("수동으로 ${manualLottoCount}장, 자동으로 ${autoLottoCount}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers)
        }
        println()
    }
}
