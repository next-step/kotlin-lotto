package lotto.ui.view

import lotto.domain.LottoNumber

fun getPurchasePrice(): Int {
    println("구입금액을 입력해 주세요.")

    return readLine()?.toIntOrNull() ?: 0
}

fun getManualLottoNumbers(): List<Set<LottoNumber>> {
    println("수동으로 구매할 로또 수를 입력해 주세요.")

    val repeatCount = readLine()?.toIntOrNull() ?: 0

    println("수동으로 구매할 번호를 입력해 주세요.")

    return List(repeatCount) {
        readLine()!!.split(",")
            .map { LottoNumber.of(it.trim().toInt()) }
            .toSet()
    }
}

fun getWinningLottoNumbers(): Set<LottoNumber> {
    println("지난 주 당첨 번호를 입력해 주세요.")

    return readLine()?.split(",")?.map { stringNumber ->
        LottoNumber.of(stringNumber.trim().toInt())
    }?.toSet() ?: emptySet()
}

fun getBonusLottoNumber(): LottoNumber {
    println("보너스 볼을 입력해 주세요.")

    return LottoNumber.of(readLine()?.toIntOrNull() ?: -1)
}
