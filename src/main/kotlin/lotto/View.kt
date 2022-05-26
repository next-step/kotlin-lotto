package lotto

object View {

    fun insertAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun printAbleToPurchaseLottoCount(lottoStore: LottoStore) {
        lottoStore.ableToPurchaseCount.also {
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
}
