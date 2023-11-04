package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoMessage
import java.lang.IllegalArgumentException

object View {

    fun messagePrintAndGetLine(message: LottoMessage): String {
        println(message)
        return getLine()
    }

    fun lottoBuyResultPrint(lotto: Lotto) {
        println(LottoMessage.PRINT_PURCHASE_QUANTITY.message.format(lotto.lines.size))
        println(lotto.lines.joinToString("\n"))
    }

    private fun getLine() = readlnOrNull() ?: throw IllegalArgumentException("입력하여 주세요.")

}
