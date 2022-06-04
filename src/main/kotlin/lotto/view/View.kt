package lotto.view

import lotto.domain.LottoStore
import lotto.domain.dto.LottoNumber

object View {

    fun insertAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun purchasableLottoCount(lottoStore: LottoStore) {
        lottoStore.also {
            println("수동으로 ${it.manualPurchasedCount}장, 자동으로 ${it.autoPurchasableCount}개 를 구매했습니다.")
        }
    }

    fun printPurchasedLottoList(purchasedLotto: List<LottoNumber>) {
        purchasedLotto.forEach {
            println("[${it.numbers.joinToString()}]")
        }
    }

    fun getLuckyDrawNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().replace(" ", "").split(",").map { it.toInt() }
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualLotto(): List<LottoNumber> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        readln().toInt().let {
            println("수동으로 구매할 번호를 입력해 주세요.")
            return getLottoNumber(it)
        }
    }

    private fun getLottoNumber(input: Int): List<LottoNumber> {
        return List(input) {
            LottoNumber(
                readln().replace(" ", "").split(",").map { lottoNumber -> lottoNumber.toInt() }
            )
        }
    }
}
