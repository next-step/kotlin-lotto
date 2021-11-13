package lotto.view.inputView

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Money

data class ManualLottoOutput(val lottos: List<Lotto>, val balance: Money)

class ManualLottoInputView(private val paidMoney: Money) {

    fun receiveManualLottos(): ManualLottoOutput {
        val count = receiveCount()
        require(Lotto.UNIT_PRICE * count <= paidMoney) { NOT_ENOUGH_MONEY }

        println(RECEIVE_MANUAL_LOTTOS_MSG)
        return ManualLottoOutput(
            (1..count).map { receiveLotto() },
            paidMoney - Lotto.UNIT_PRICE * count
        )
    }

    private fun receiveCount(): Int {
        println(RECEIVE_MANUAL_LOTTO_COUNT_MSG)
        val input = readLine()
        require(!input.isNullOrBlank()) { EMPTY_STRING_ERROR_MSG }
        return input.toInt()
    }

    private fun receiveLotto(): Lotto {
        val input = readLine()
        require(!input.isNullOrBlank()) { EMPTY_STRING_ERROR_MSG }
        return Lotto(
            input
                .filter { !it.isWhitespace() }
                .split(",")
                .map { LottoNumber(it.toInt()) }
        )
    }

    companion object {
        private const val RECEIVE_MANUAL_LOTTO_COUNT_MSG = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val RECEIVE_MANUAL_LOTTOS_MSG = "수동으로 구매할 번호를 입력해 주세요."
        private const val NOT_ENOUGH_MONEY = "금액이 부족합니다."
        private const val EMPTY_STRING_ERROR_MSG = "입력이 비어있습니다."
    }
}
