package lotto.view

object InputView {

    fun inputPurchaseMoney(): Long {
        println("구입금액을 입력해 주세요.")

        val purchaseMoney = readlnOrNull()?.toLong()

        require(purchaseMoney != null && purchaseMoney >= 0) { "구입금액은 0원보다 커야합니다." }

        return purchaseMoney
    }

    fun inputWinningLottoNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winningLottoNumbers = readlnOrNull()
            ?.split(",")
            ?.mapNotNull {
                it.trim().toIntOrNull()
            }?.toSet()

        require(winningLottoNumbers != null) { "당첨 번호가 입려되지 않았습니다." }

        return winningLottoNumbers
    }
}
