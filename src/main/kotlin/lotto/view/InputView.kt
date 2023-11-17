package lotto.view

import lotto.dto.WinningLottoDto
import lotto.dto.PurchaseAmountDto

object InputView {
    fun readPrice(): PurchaseAmountDto {

        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                return PurchaseAmountDto(readln().toInt())
            } catch (e: NumberFormatException) {
                println("숫자만 입력 가능합니다.")
            }
        }
    }

    fun inputWinningNumbers(): WinningLottoDto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return WinningLottoDto.of(readlnOrNull())
    }
}
