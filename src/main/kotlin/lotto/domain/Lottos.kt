package lotto.domain

data class Lottos(
    val automaticLottos: List<Lotto>,
    val passivityLottos: List<Lotto>,
) {

    fun getAutomaticLottoSize(): Int = automaticLottos.size

    fun getPassivityLottoSize(): Int = passivityLottos.size

    fun getLottos(): List<Lotto> = passivityLottos + automaticLottos
}
