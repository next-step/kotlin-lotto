package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNumber

class InputView {

    fun getBuyingPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputLastWinningNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
            .split(DEFAULT_DELIMITER)
            .map { it.trim() }
            .map { LottoNumber.from(it.toInt()) }
            .let(::Lotto)
    }

    fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber.from(readln().toInt())
    }

    fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun createManualLotto(manualLottoCount: Int): List<Lotto> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        var lottos = listOf<Lotto>()
        repeat(manualLottoCount) {
            val input = readLottoInput()
            lottos = lottos.plus(input)
        }
        return lottos
    }

    private fun readLottoInput(): Lotto {
        return readln().split(DEFAULT_DELIMITER)
            .map { LottoNumber.from(it.toInt()) }
            .let(::Lotto)
    }

    private fun List<Lotto>.plus(lotto: Lotto): List<Lotto> {
        val lottos = ArrayList<Lotto>(this.size + 1)
        lottos.addAll(this)
        lottos.add(lotto)
        return lottos
    }

    companion object {
        private const val DEFAULT_DELIMITER = ","
    }
}
