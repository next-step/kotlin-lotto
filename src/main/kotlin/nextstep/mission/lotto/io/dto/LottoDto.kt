package nextstep.mission.lotto.io.dto

import nextstep.mission.lotto.Lotto

data class LottoDto(val lottoNumbers: List<List<Int>>) {
    companion object {
        fun from(lotto: Lotto) = lotto.lottoNumbers.map {
            it.numbers.map { number -> number.number }
        }.let { LottoDto(it) }
    }
}
