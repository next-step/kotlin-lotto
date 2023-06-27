package lotto

import lotto.domain.LottoManager

fun main() {

    val lottoManager = LottoManager()
    val lottos = lottoManager.buyLotto()
    lottoManager.getResult(lottos)
}
