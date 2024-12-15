package lotto.domain

class ManualLottos(private val lottos: List<Lotto>) : Collection<Lotto> by lottos
