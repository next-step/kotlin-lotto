package lotto.domain

import lotto.domain.generator.Generator

class Lotto(generator: Generator) {

    val lottoNums = LottoNums(generator)
}