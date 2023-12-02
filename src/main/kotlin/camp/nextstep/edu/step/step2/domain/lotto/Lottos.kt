package camp.nextstep.edu.step.step2.domain.lotto

import java.util.stream.Collectors

class Lottos(
    val lottos: List<Lotto>
) {

    init {
        require(lottos.isNotEmpty()) { "로또는 1개 이상이어야 합니다." }
    }

    fun getLottoElements(): List<List<Int>> {
        return lottos.stream()
            .map { lotto -> lotto.getNumberElements() }
            .collect(Collectors.toList())
    }

    fun getLottoSize(): Int {
        return lottos.size
    }

}
