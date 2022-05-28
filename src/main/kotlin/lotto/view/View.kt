package lotto.view

import lotto.domain.LottoStore
import lotto.domain.dto.LottoNumber

object View {

    fun insertAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun purchasableLottoCount(lottoStore: LottoStore) {
        lottoStore.purchasable.also {
            println("${it}개를 구매했습니다.")
        }
    }

    fun printPurchasedLottoList(purchasedLotto: List<LottoNumber>) {
        purchasedLotto.forEach {
            println("[${it.numbers.joinToString()}]")
        }
    }

    fun getLuckyDrawNumber(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun getBonusNumber(): String {
        println("보너스 볼을 입력해 주세요.")
        return readln()
    }
}
