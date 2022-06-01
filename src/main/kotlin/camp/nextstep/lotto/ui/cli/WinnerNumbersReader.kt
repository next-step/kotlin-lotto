package camp.nextstep.lotto.ui.cli

import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumbers

object WinnerNumbersReader {

    fun read(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val readLine = requireNotNull(readLine())
        val winnerNumbers = readLine.split(",").map { it.trim().toInt() }
        require(winnerNumbers.size == LottoNumbers.LOTTO_NUMBERS) { "${LottoNumbers.LOTTO_NUMBERS} 개의 당첨 번호를 입력해주세요." }
        check(winnerNumbers.all { it in LottoNumber.LOTTO_NUMBER_RANGE }) { "로또 번호는 ${LottoNumber.LOTTO_NUMBER_RANGE.first} 이상 ${LottoNumber.LOTTO_NUMBER_RANGE.last} 이하의 숫자여야 합니다." }
        return winnerNumbers.map { LottoNumber.of(it) }
    }
}
