package lotto.userInterface

import lotto.dto.LottoNumbersDto

class Console : UserInterface {
    override fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: 0
    }

    override fun outputPurchasedMessage(dto: LottoNumbersDto) {
        println("${dto.count}개를 구매했습니다.")
        dto.lottos.forEach { println(it) }
    }
}
