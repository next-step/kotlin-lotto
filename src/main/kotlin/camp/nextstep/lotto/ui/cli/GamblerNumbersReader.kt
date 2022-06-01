package camp.nextstep.lotto.ui.cli

import camp.nextstep.lotto.ui.GamblerNumbers

object GamblerNumbersReader {

    fun read(): GamblerNumbers {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val n = requireNotNull(readLine()).toInt()

        println("수동으로 구매할 번호를 입력해 주세요.")
        val numbers = mutableListOf<List<Int>>()
        repeat(n) {
            numbers += requireNotNull(readLine()).split(',').map { it.trim().toInt() }
        }

        return GamblerNumbers(numbers)
    }
}
