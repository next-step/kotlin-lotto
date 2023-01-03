package lotto.domain

class PublishLotto(val manualLottos: List<Lotto>, val autoLottos: List<Lotto>) {
    fun getAllLotto(): List<Lotto> = manualLottos + autoLottos
}
