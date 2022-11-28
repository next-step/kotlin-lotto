package nextstep.mission.lotto.fixture

import nextstep.mission.lotto.vo.LottoNumber
import nextstep.mission.lotto.vo.LottoNumbers

fun lottoNumberListOf(vararg elements: Int): List<LottoNumber> = elements.map { LottoNumber(it) }

fun lottoNumbersListOf(vararg elements: List<Int>): List<LottoNumbers> =
    elements.map { LottoNumbers(it.map { number -> LottoNumber(number) }) }
