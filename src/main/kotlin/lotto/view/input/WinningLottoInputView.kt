package lotto.view.input

import lotto.view.dto.WinningLottoDto

object WinningLottoInputView {
    fun print(): WinningLottoDto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return WinningLottoDto(readln().split(",").map { it.trim().toInt() })
    }
}
