package camp.nextstep.lotto.ui.cli

import camp.nextstep.lotto.number.LottoNumber

object BonusNumberReader {

    fun read(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val readLine = requireNotNull(readLine())
        val bonusNumber = readLine.toInt()
        check(bonusNumber in LottoNumber.LOTTO_NUMBER_RANGE) { "로또 번호는 ${LottoNumber.LOTTO_NUMBER_RANGE.first} 이상 ${LottoNumber.LOTTO_NUMBER_RANGE.last} 이하의 숫자여야 합니다." }
        return LottoNumber.of(bonusNumber)
    }
}
