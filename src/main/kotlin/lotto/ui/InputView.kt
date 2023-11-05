package lotto.ui

import lotto.model.LottoInfo

object InputView {

    private const val LATEST_WIN_INFO_DELIMITER = ", "

    fun getPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = readlnOrNull()
        requireNotNull(purchaseAmount) {
            "구매 금액은 null을 허용하지 않습니다."
        }
        return purchaseAmount
    }

    fun getLatestWinInfo(): LottoInfo {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val latestWinNumbers = readlnOrNull()
        requireNotNull(latestWinNumbers) {
            "지난 주 당첨 번호는 null을 허용하지 않습니다."
        }
        return LottoInfo(latestWinNumbers.split(LATEST_WIN_INFO_DELIMITER).map { it.toInt() })
    }
}