package lotto.view.input

import lotto.view.dto.lotto.LottoDto
import lotto.view.dto.lotto.LottosDto

object ManualLottosInputView {
    fun print(amount: Int): LottosDto {
        println("수동으로 구매할 번호를 입력해 주세요")
        val lottos =
            List(amount) {
                LottoDto(readln().split(",").map { it.trim().toInt() })
            }

        return LottosDto(lottos = lottos)
    }
}
