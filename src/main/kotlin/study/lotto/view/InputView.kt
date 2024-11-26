package study.lotto.view

import study.lotto.LottoService
import study.lotto.model.Lotto

/**
 * @author 이상준
 */
class InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요: ")
        return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("입력이 없습니다.")
    }

    fun inputWinLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요: ")
        val lottos = readlnOrNull()?.split(",")?.map { it.toInt() } ?: throw IllegalArgumentException("입력이 없습니다.")
        return Lotto(lottos.toSet())
    }

    fun inputBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonus = readlnOrNull()?.toInt() ?: throw IllegalArgumentException("입력이 없습니다.")
        require(bonus in LottoService.MIN_LOTTO_NUMBER..LottoService.MAX_LOTTO_NUMBER) {
            "보너스 볼은 ${LottoService.MIN_LOTTO_NUMBER} ~ ${LottoService.MAX_LOTTO_NUMBER} 사이의 숫자입니다."
        }
        return bonus
    }
}
