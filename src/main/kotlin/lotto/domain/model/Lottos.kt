package lotto.domain.model

import lotto.domain.Lotto

data class Lottos(
    val automaticLottos: List<Lotto> = emptyList(),
    val passivityLottos: List<Lotto> = emptyList(),
) {

    fun getAutomaticLottoSize(): Int = automaticLottos.size

    fun getPassivityLottoSize(): Int = passivityLottos.size

    fun getLottos(): List<Lotto> = passivityLottos + automaticLottos
}
