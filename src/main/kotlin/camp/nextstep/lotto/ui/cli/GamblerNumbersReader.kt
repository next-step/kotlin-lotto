package camp.nextstep.lotto.ui.cli

import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumber.Companion.toLottoNumbers
import camp.nextstep.lotto.ui.GamblerNumbers

object GamblerNumbersReader {

    fun read(): GamblerNumbers {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val n = requireNotNull(readLine()).toInt()

        println("수동으로 구매할 번호를 입력해 주세요.")
        val lottoNumbersList = mutableListOf<List<LottoNumber>>()
        repeat(n) {
            lottoNumbersList += requireNotNull(readLine()).split(',').map { it.trim().toInt() }.toLottoNumbers()
        }

        return GamblerNumbers(lottoNumbersList)
    }
}
