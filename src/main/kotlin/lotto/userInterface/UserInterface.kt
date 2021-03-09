package lotto.userInterface

import lotto.dto.LottoNumbersDto

interface UserInterface {
    fun inputPurchaseAmount(): Int
    fun outputPurchasedMessage(dto: LottoNumbersDto)
}
