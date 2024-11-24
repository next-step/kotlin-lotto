package study.lotto.view

import study.lotto.model.Lotto

/**
 * @author 이상준
 */
class InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요: ")
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("입력이 없습니다.")
    }

    fun inputWinLotte(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요: ")
        val lottos = readlnOrNull()?.split(",")?.map { it.toInt() } ?: throw IllegalArgumentException("입력이 없습니다.")
        return Lotto(lottos.toSet())
    }
}
